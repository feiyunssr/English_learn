package com.englishlearn.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "documents")
data class Document(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val filePath: String,
    val fileType: DocumentType,
    val category: String,
    val tags: List<String> = emptyList(),
    val isBookmarked: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val lastAccessedAt: Long = System.currentTimeMillis(),
    val readingProgress: Float = 0f,
    val totalPages: Int = 0,
    val currentPage: Int = 0,
    val fileSize: Long = 0L,
    val languageLevel: String? = null,
    val summary: String? = null
)

enum class DocumentType {
    PDF, TXT, DOC, DOCX, EPUB, URL
}