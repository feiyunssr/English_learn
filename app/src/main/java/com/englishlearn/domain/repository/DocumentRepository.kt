package com.englishlearn.domain.repository

import com.englishlearn.data.entities.Document
import kotlinx.coroutines.flow.Flow

interface DocumentRepository {
    fun getAllDocuments(): Flow<List<Document>>
    fun getDocumentsByCategory(category: String): Flow<List<Document>>
    fun getBookmarkedDocuments(): Flow<List<Document>>
    fun getAllCategories(): Flow<List<String>>
    suspend fun getDocumentById(id: String): Document?
    suspend fun insertDocument(document: Document)
    suspend fun updateDocument(document: Document)
    suspend fun updateReadingProgress(id: String, progress: Float, currentPage: Int)
    suspend fun updateBookmarkStatus(id: String, isBookmarked: Boolean)
    suspend fun deleteDocument(document: Document)
    suspend fun deleteDocumentById(id: String)
}