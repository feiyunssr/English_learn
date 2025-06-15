package com.englishlearn.data.dao

import androidx.room.*
import com.englishlearn.data.entities.Translation
import kotlinx.coroutines.flow.Flow

@Dao
interface TranslationDao {
    @Query("SELECT * FROM translations ORDER BY createdAt DESC")
    fun getAllTranslations(): Flow<List<Translation>>

    @Query("SELECT * FROM translations WHERE originalText = :originalText")
    suspend fun getTranslationByText(originalText: String): Translation?

    @Query("SELECT * FROM translations WHERE isBookmarked = 1 ORDER BY createdAt DESC")
    fun getBookmarkedTranslations(): Flow<List<Translation>>

    @Query("SELECT * FROM translations WHERE documentId = :documentId ORDER BY createdAt DESC")
    fun getTranslationsByDocument(documentId: String): Flow<List<Translation>>

    @Query("UPDATE translations SET isBookmarked = :isBookmarked WHERE id = :id")
    suspend fun updateBookmarkStatus(id: String, isBookmarked: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTranslation(translation: Translation)

    @Update
    suspend fun updateTranslation(translation: Translation)

    @Delete
    suspend fun deleteTranslation(translation: Translation)

    @Query("DELETE FROM translations WHERE id = :id")
    suspend fun deleteTranslationById(id: String)
}