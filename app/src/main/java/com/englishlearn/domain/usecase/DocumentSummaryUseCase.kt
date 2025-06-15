package com.englishlearn.domain.usecase

import android.content.Context
import com.englishlearn.data.api.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DocumentSummaryUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val googleAIApi: GoogleAIApi
) {
    
    suspend fun summarizeDocument(
        documentContent: String,
        documentTitle: String,
        summaryType: SummaryType = SummaryType.BRIEF
    ): Result<String> = withContext(Dispatchers.IO) {
        try {
            // Get API key from settings
            val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
            val apiKey = prefs.getString("google_api_key", "") ?: ""
            val aiModel = prefs.getString("google_ai_model", "gemini-pro") ?: "gemini-pro"
            
            if (apiKey.isEmpty()) {
                return@withContext Result.failure(Exception("请先在设置中配置Google API Key"))
            }
            
            // Prepare summary request based on type
            val prompt = when (summaryType) {
                SummaryType.BRIEF -> 
                    "提供以下文档《$documentTitle》的简短摘要（2-3句话）：\n\n$documentContent"
                SummaryType.DETAILED -> 
                    "提供以下文档《$documentTitle》的详细摘要，包含关键要点：\n\n$documentContent"
                SummaryType.KEY_POINTS -> 
                    "从以下文档《$documentTitle》中提取主要关键点（要点形式）：\n\n$documentContent"
                SummaryType.CHAPTER -> 
                    "提供以下文档《$documentTitle》的逐章节摘要：\n\n$documentContent"
            }
            
            val request = GoogleAIRequest(
                contents = listOf(
                    Content(
                        parts = listOf(Part(
                            "你是一位专业的文档分析专家。请用中文提供清晰、简洁的摘要。\n\n$prompt"
                        )),
                        role = "user"
                    )
                ),
                generationConfig = GenerationConfig(
                    temperature = 0.5,
                    maxOutputTokens = 2000
                )
            )
            
            // Make API call
            val response = googleAIApi.generateContent(aiModel, apiKey, request)
            
            val summary = response.candidates.firstOrNull()?.content?.parts?.firstOrNull()?.text
                ?: throw Exception("摘要结果为空")
            
            Result.success(summary)
        } catch (e: Exception) {
            when {
                e.message?.contains("API_KEY_INVALID") == true -> 
                    Result.failure(Exception("Google API Key无效，请检查设置"))
                e.message?.contains("RATE_LIMIT_EXCEEDED") == true -> 
                    Result.failure(Exception("请求过于频繁，请稍后再试"))
                else -> Result.failure(Exception("生成摘要失败: ${e.message}"))
            }
        }
    }
    
    enum class SummaryType {
        BRIEF,      // 简短摘要
        DETAILED,   // 详细摘要
        KEY_POINTS, // 关键点提取
        CHAPTER     // 章节摘要
    }
}