package com.englishlearn.data.repository

import com.englishlearn.data.dao.DocumentDao
import com.englishlearn.data.entities.Document
import com.englishlearn.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DocumentRepositoryImpl @Inject constructor(
    private val documentDao: DocumentDao
) : DocumentRepository {

    override fun getAllDocuments(): Flow<List<Document>> = documentDao.getAllDocuments()

    override fun getDocumentsByCategory(category: String): Flow<List<Document>> = 
        documentDao.getDocumentsByCategory(category)

    override fun getBookmarkedDocuments(): Flow<List<Document>> = 
        documentDao.getBookmarkedDocuments()

    override fun getAllCategories(): Flow<List<String>> = documentDao.getAllCategories()

    override suspend fun getDocumentById(id: String): Document? = 
        documentDao.getDocumentById(id)

    override suspend fun insertDocument(document: Document) = 
        documentDao.insertDocument(document)

    override suspend fun updateDocument(document: Document) = 
        documentDao.updateDocument(document)

    override suspend fun updateReadingProgress(id: String, progress: Float, currentPage: Int) = 
        documentDao.updateReadingProgress(id, progress, currentPage, System.currentTimeMillis())

    override suspend fun updateBookmarkStatus(id: String, isBookmarked: Boolean) = 
        documentDao.updateBookmarkStatus(id, isBookmarked)

    override suspend fun deleteDocument(document: Document) = 
        documentDao.deleteDocument(document)

    override suspend fun deleteDocumentById(id: String) = 
        documentDao.deleteDocumentById(id)
}