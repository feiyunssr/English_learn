package com.englishlearn.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "translations")
data class Translation(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val originalText: String,
    val translatedText: String,
    val sourceLanguage: String = "en",
    val targetLanguage: String = "zh",
    val aiModel: String,
    val documentId: String? = null,
    val context: String? = null,
    val confidence: Float = 0f,
    val isBookmarked: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)