package com.englishlearn.domain.usecase

import android.content.Context
import android.net.Uri
import com.englishlearn.data.entities.Document
import com.englishlearn.data.entities.DocumentType
import com.englishlearn.domain.repository.DocumentRepository
import com.englishlearn.utils.DocumentProcessor
import com.englishlearn.utils.FileUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DocumentImportUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val documentRepository: DocumentRepository,
    private val documentProcessor: DocumentProcessor,
    private val fileUtils: FileUtils
) {

    suspend fun importDocument(
        uri: Uri,
        title: String,
        category: String = "未分类",
        tags: List<String> = emptyList()
    ): Result<Document> = withContext(Dispatchers.IO) {
        try {
            // Copy file to app's internal storage
            val fileName = fileUtils.getFileName(uri) ?: "document_${System.currentTimeMillis()}"
            val internalFile = fileUtils.copyToInternalStorage(uri, fileName)
            
            // Determine document type
            val documentType = DocumentType.valueOf(
                fileName.substringAfterLast(".", "txt").uppercase()
            )
            
            // 暂时不提取文本内容，避免导入时崩溃
            // val textContent = documentProcessor.extractText(internalFile, documentType)
            val pageCount = try {
                documentProcessor.getPageCount(internalFile, documentType)
            } catch (e: Exception) {
                1 // 默认页数
            }
            
            // Create document entity
            val document = Document(
                id = UUID.randomUUID().toString(),
                title = title.ifEmpty { fileName.substringBeforeLast(".") },
                filePath = internalFile.absolutePath,
                fileType = documentType,
                category = category,
                tags = tags,
                totalPages = pageCount,
                fileSize = internalFile.length(),
                createdAt = System.currentTimeMillis(),
                lastAccessedAt = System.currentTimeMillis()
            )
            
            // Save to database
            documentRepository.insertDocument(document)
            
            Result.success(document)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun importFromUrl(
        url: String,
        title: String,
        category: String = "网络文档",
        tags: List<String> = emptyList()
    ): Result<Document> = withContext(Dispatchers.IO) {
        try {
            // Download file from URL
            val downloadedFile = fileUtils.downloadFromUrl(url)
            
            val document = Document(
                id = UUID.randomUUID().toString(),
                title = title,
                filePath = downloadedFile.absolutePath,
                fileType = DocumentType.URL,
                category = category,
                tags = tags,
                fileSize = downloadedFile.length(),
                createdAt = System.currentTimeMillis(),
                lastAccessedAt = System.currentTimeMillis()
            )
            
            documentRepository.insertDocument(document)
            
            Result.success(document)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}