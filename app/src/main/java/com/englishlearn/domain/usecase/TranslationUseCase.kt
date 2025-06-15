package com.englishlearn.domain.usecase

import android.content.Context
import com.englishlearn.data.api.*
import com.englishlearn.data.entities.Translation
import com.englishlearn.domain.repository.VocabularyRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TranslationUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val googleAIApi: GoogleAIApi,
    private val vocabularyRepository: VocabularyRepository
) {
    
    suspend fun translateText(
        text: String,
        sourceLanguage: String = "English",
        targetLanguage: String = "Chinese"
    ): Result<Translation> = withContext(Dispatchers.IO) {
        try {
            // Get API key from settings
            val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
            val apiKey = prefs.getString("google_api_key", "") ?: ""
            val aiModel = prefs.getString("google_ai_model", "gemini-pro") ?: "gemini-pro"
            
            if (apiKey.isEmpty()) {
                return@withContext Result.failure(Exception("请先在设置中配置Google API Key"))
            }
            
            // Prepare translation request
            val prompt = "Translate the following $sourceLanguage text to $targetLanguage. " +
                    "Provide only the translation without any explanations:\n\n$text"
            
            val request = GoogleAIRequest(
                contents = listOf(
                    Content(
                        parts = listOf(Part(prompt)),
                        role = "user"
                    )
                ),
                generationConfig = GenerationConfig(
                    temperature = 0.3,
                    maxOutputTokens = 1000
                )
            )
            
            // Make API call
            val response = googleAIApi.generateContent(aiModel, apiKey, request)
            
            val translatedText = response.candidates.firstOrNull()?.content?.parts?.firstOrNull()?.text
                ?: throw Exception("翻译结果为空")
            
            val translation = Translation(
                id = UUID.randomUUID().toString(),
                originalText = text,
                translatedText = translatedText,
                sourceLanguage = sourceLanguage,
                targetLanguage = targetLanguage,
                aiModel = "google-$aiModel",
                createdAt = System.currentTimeMillis()
            )
            
            Result.success(translation)
        } catch (e: Exception) {
            when {
                e.message?.contains("API_KEY_INVALID") == true -> 
                    Result.failure(Exception("Google API Key无效，请检查设置"))
                e.message?.contains("RATE_LIMIT_EXCEEDED") == true -> 
                    Result.failure(Exception("请求过于频繁，请稍后再试"))
                else -> Result.failure(Exception("翻译失败: ${e.message}"))
            }
        }
    }
}