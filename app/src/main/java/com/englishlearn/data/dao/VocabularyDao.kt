package com.englishlearn.data.dao

import androidx.room.*
import com.englishlearn.data.entities.Vocabulary
import kotlinx.coroutines.flow.Flow

@Dao
interface VocabularyDao {
    @Query("SELECT * FROM vocabulary ORDER BY createdAt DESC")
    fun getAllVocabulary(): Flow<List<Vocabulary>>

    @Query("SELECT * FROM vocabulary WHERE word = :word")
    suspend fun getVocabularyByWord(word: String): Vocabulary?

    @Query("SELECT * FROM vocabulary WHERE isBookmarked = 1 ORDER BY createdAt DESC")
    fun getBookmarkedVocabulary(): Flow<List<Vocabulary>>

    @Query("SELECT * FROM vocabulary WHERE documentId = :documentId ORDER BY createdAt DESC")
    fun getVocabularyByDocument(documentId: String): Flow<List<Vocabulary>>

    @Query("SELECT * FROM vocabulary WHERE nextReviewAt <= :currentTime ORDER BY nextReviewAt ASC")
    suspend fun getVocabularyForReview(currentTime: Long): List<Vocabulary>

    @Query("UPDATE vocabulary SET reviewCount = reviewCount + 1, correctCount = correctCount + :correct, lastReviewedAt = :reviewTime, nextReviewAt = :nextReviewTime WHERE id = :id")
    suspend fun updateReviewStats(id: String, correct: Int, reviewTime: Long, nextReviewTime: Long)

    @Query("UPDATE vocabulary SET isBookmarked = :isBookmarked WHERE id = :id")
    suspend fun updateBookmarkStatus(id: String, isBookmarked: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVocabulary(vocabulary: Vocabulary)

    @Update
    suspend fun updateVocabulary(vocabulary: Vocabulary)

    @Delete
    suspend fun deleteVocabulary(vocabulary: Vocabulary)

    @Query("DELETE FROM vocabulary WHERE id = :id")
    suspend fun deleteVocabularyById(id: String)
}