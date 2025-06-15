package com.englishlearn.domain.usecase

import com.englishlearn.data.api.DictionaryApi
import com.englishlearn.data.dictionary.BuiltInDictionary
import com.englishlearn.data.entities.DifficultyLevel
import com.englishlearn.data.entities.Vocabulary
import com.englishlearn.domain.repository.VocabularyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DictionaryUseCase @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val vocabularyRepository: VocabularyRepository,
    private val builtInDictionary: BuiltInDictionary
) {

    suspend fun lookupWord(
        word: String,
        documentId: String? = null,
        context: String? = null
    ): Result<Vocabulary> = withContext(Dispatchers.IO) {
        try {
            // First check if word exists in local database
            val existingVocabulary = vocabularyRepository.getVocabularyByWord(word.lowercase())
            if (existingVocabulary != null) {
                return@withContext Result.success(existingVocabulary)
            }

            // Try built-in dictionary first
            val builtInDefinition = builtInDictionary.getDefinition(word)
            if (builtInDefinition != "暂无词典数据。您可以尝试使用在线词典或AI翻译功能。") {
                val vocabulary = Vocabulary(
                    word = word.lowercase(),
                    definition = builtInDefinition,
                    phonetic = builtInDictionary.lookupWord(word)?.phonetic,
                    difficulty = determineDifficulty(word),
                    frequency = calculateFrequency(word),
                    documentId = documentId,
                    context = context
                )
                
                // Save to local database
                vocabularyRepository.insertVocabulary(vocabulary)
                
                return@withContext Result.success(vocabulary)
            }

            // If not in built-in dictionary, try online API
            try {
                val response = dictionaryApi.getWordDefinition(word.lowercase())
                
                if (response.isSuccessful && response.body()?.isNotEmpty() == true) {
                    val dictionaryData = response.body()!!.first()
                    
                    val vocabulary = Vocabulary(
                        word = dictionaryData.word,
                        definition = extractDefinition(dictionaryData),
                        phonetic = extractPhonetic(dictionaryData),
                        audioUrl = extractAudioUrl(dictionaryData),
                        examples = extractExamples(dictionaryData),
                        synonyms = extractSynonyms(dictionaryData),
                        antonyms = extractAntonyms(dictionaryData),
                        difficulty = determineDifficulty(word),
                        frequency = calculateFrequency(word),
                        documentId = documentId,
                        context = context
                    )
                    
                    // Save to local database
                    vocabularyRepository.insertVocabulary(vocabulary)
                    
                    Result.success(vocabulary)
                } else {
                    // Fallback: create basic vocabulary entry
                    val basicVocabulary = Vocabulary(
                        word = word,
                        definition = "词典查询失败，请尝试AI翻译功能。",
                        documentId = documentId,
                        context = context
                    )
                    vocabularyRepository.insertVocabulary(basicVocabulary)
                    Result.success(basicVocabulary)
                }
            } catch (apiException: Exception) {
                // If API fails, return built-in result or basic entry
                val basicVocabulary = Vocabulary(
                    word = word,
                    definition = builtInDefinition,
                    documentId = documentId,
                    context = context
                )
                vocabularyRepository.insertVocabulary(basicVocabulary)
                Result.success(basicVocabulary)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun extractDefinition(dictionaryData: com.englishlearn.data.api.DictionaryResponse): String {
        return dictionaryData.meanings.firstOrNull()?.definitions?.firstOrNull()?.definition 
            ?: "No definition available"
    }

    private fun extractPhonetic(dictionaryData: com.englishlearn.data.api.DictionaryResponse): String? {
        return dictionaryData.phonetics.firstOrNull { it.text != null }?.text
    }

    private fun extractAudioUrl(dictionaryData: com.englishlearn.data.api.DictionaryResponse): String? {
        return dictionaryData.phonetics.firstOrNull { it.audio?.isNotEmpty() == true }?.audio
    }

    private fun extractExamples(dictionaryData: com.englishlearn.data.api.DictionaryResponse): List<String> {
        return dictionaryData.meanings.flatMap { meaning ->
            meaning.definitions.mapNotNull { it.example }
        }.take(3) // Limit to 3 examples
    }

    private fun extractSynonyms(dictionaryData: com.englishlearn.data.api.DictionaryResponse): List<String> {
        return dictionaryData.meanings.flatMap { meaning ->
            meaning.definitions.flatMap { it.synonyms }
        }.distinct().take(5) // Limit to 5 synonyms
    }

    private fun extractAntonyms(dictionaryData: com.englishlearn.data.api.DictionaryResponse): List<String> {
        return dictionaryData.meanings.flatMap { meaning ->
            meaning.definitions.flatMap { it.antonyms }
        }.distinct().take(5) // Limit to 5 antonyms
    }

    private fun determineDifficulty(word: String): DifficultyLevel {
        // Simple heuristic based on word length and common patterns
        return when {
            word.length <= 4 -> DifficultyLevel.ELEMENTARY
            word.length <= 7 -> DifficultyLevel.INTERMEDIATE
            word.length > 10 || word.contains(Regex("[^a-zA-Z]")) -> DifficultyLevel.ADVANCED
            else -> DifficultyLevel.INTERMEDIATE
        }
    }

    private fun calculateFrequency(word: String): Int {
        // Simple frequency calculation based on common English words
        val commonWords = setOf("the", "be", "to", "of", "and", "a", "in", "that", "have", 
            "i", "it", "for", "not", "on", "with", "he", "as", "you", "do", "at")
        
        return when {
            commonWords.contains(word.lowercase()) -> 100
            word.length <= 4 -> 75
            word.length <= 7 -> 50
            else -> 25
        }
    }
}