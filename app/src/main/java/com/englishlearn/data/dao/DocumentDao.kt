package com.englishlearn.data.dao

import androidx.room.*
import com.englishlearn.data.entities.Document
import kotlinx.coroutines.flow.Flow

@Dao
interface DocumentDao {
    @Query("SELECT * FROM documents ORDER BY lastAccessedAt DESC")
    fun getAllDocuments(): Flow<List<Document>>

    @Query("SELECT * FROM documents WHERE id = :id")
    suspend fun getDocumentById(id: String): Document?

    @Query("SELECT * FROM documents WHERE category = :category ORDER BY lastAccessedAt DESC")
    fun getDocumentsByCategory(category: String): Flow<List<Document>>

    @Query("SELECT * FROM documents WHERE isBookmarked = 1 ORDER BY lastAccessedAt DESC")
    fun getBookmarkedDocuments(): Flow<List<Document>>

    @Query("SELECT DISTINCT category FROM documents")
    fun getAllCategories(): Flow<List<String>>

    @Query("UPDATE documents SET readingProgress = :progress, currentPage = :currentPage, lastAccessedAt = :accessTime WHERE id = :id")
    suspend fun updateReadingProgress(id: String, progress: Float, currentPage: Int, accessTime: Long)

    @Query("UPDATE documents SET isBookmarked = :isBookmarked WHERE id = :id")
    suspend fun updateBookmarkStatus(id: String, isBookmarked: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDocument(document: Document)

    @Update
    suspend fun updateDocument(document: Document)

    @Delete
    suspend fun deleteDocument(document: Document)

    @Query("DELETE FROM documents WHERE id = :id")
    suspend fun deleteDocumentById(id: String)
}