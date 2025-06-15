package com.englishlearn.domain.repository

import com.englishlearn.data.entities.Vocabulary
import kotlinx.coroutines.flow.Flow

interface VocabularyRepository {
    fun getAllVocabulary(): Flow<List<Vocabulary>>
    fun getBookmarkedVocabulary(): Flow<List<Vocabulary>>
    fun getVocabularyByDocument(documentId: String): Flow<List<Vocabulary>>
    suspend fun getVocabularyByWord(word: String): Vocabulary?
    suspend fun getVocabularyForReview(): List<Vocabulary>
    suspend fun insertVocabulary(vocabulary: Vocabulary)
    suspend fun updateVocabulary(vocabulary: Vocabulary)
    suspend fun updateReviewStats(id: String, correct: Boolean)
    suspend fun updateBookmarkStatus(id: String, isBookmarked: Boolean)
    suspend fun deleteVocabulary(vocabulary: Vocabulary)
}