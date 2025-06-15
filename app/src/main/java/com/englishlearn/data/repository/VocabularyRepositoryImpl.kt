package com.englishlearn.data.repository

import com.englishlearn.data.dao.VocabularyDao
import com.englishlearn.data.entities.Vocabulary
import com.englishlearn.domain.repository.VocabularyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VocabularyRepositoryImpl @Inject constructor(
    private val vocabularyDao: VocabularyDao
) : VocabularyRepository {

    override fun getAllVocabulary(): Flow<List<Vocabulary>> = vocabularyDao.getAllVocabulary()

    override fun getBookmarkedVocabulary(): Flow<List<Vocabulary>> = 
        vocabularyDao.getBookmarkedVocabulary()

    override fun getVocabularyByDocument(documentId: String): Flow<List<Vocabulary>> = 
        vocabularyDao.getVocabularyByDocument(documentId)

    override suspend fun getVocabularyByWord(word: String): Vocabulary? = 
        vocabularyDao.getVocabularyByWord(word)

    override suspend fun getVocabularyForReview(): List<Vocabulary> = 
        vocabularyDao.getVocabularyForReview(System.currentTimeMillis())

    override suspend fun insertVocabulary(vocabulary: Vocabulary) = 
        vocabularyDao.insertVocabulary(vocabulary)

    override suspend fun updateVocabulary(vocabulary: Vocabulary) = 
        vocabularyDao.updateVocabulary(vocabulary)

    override suspend fun updateReviewStats(id: String, correct: Boolean) {
        val currentTime = System.currentTimeMillis()
        val nextReviewTime = calculateNextReviewTime(correct, currentTime)
        vocabularyDao.updateReviewStats(
            id = id,
            correct = if (correct) 1 else 0,
            reviewTime = currentTime,
            nextReviewTime = nextReviewTime
        )
    }

    override suspend fun updateBookmarkStatus(id: String, isBookmarked: Boolean) = 
        vocabularyDao.updateBookmarkStatus(id, isBookmarked)

    override suspend fun deleteVocabulary(vocabulary: Vocabulary) = 
        vocabularyDao.deleteVocabulary(vocabulary)

    private fun calculateNextReviewTime(correct: Boolean, currentTime: Long): Long {
        val intervals = if (correct) {
            listOf(1, 3, 7, 14, 30) // days
        } else {
            listOf(1) // review again tomorrow if incorrect
        }
        val intervalIndex = 0 // This would be based on review history in a real implementation
        val days = intervals.getOrElse(intervalIndex) { 30 }
        return currentTime + (days * 24 * 60 * 60 * 1000L)
    }
}