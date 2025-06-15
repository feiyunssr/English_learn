package com.englishlearn.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "vocabulary")
data class Vocabulary(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val word: String,
    val definition: String,
    val phonetic: String? = null,
    val audioUrl: String? = null,
    val examples: List<String> = emptyList(),
    val synonyms: List<String> = emptyList(),
    val antonyms: List<String> = emptyList(),
    val difficulty: DifficultyLevel = DifficultyLevel.UNKNOWN,
    val frequency: Int = 0,
    val documentId: String? = null,
    val context: String? = null,
    val isBookmarked: Boolean = false,
    val reviewCount: Int = 0,
    val correctCount: Int = 0,
    val createdAt: Long = System.currentTimeMillis(),
    val lastReviewedAt: Long? = null,
    val nextReviewAt: Long? = null
)

enum class DifficultyLevel {
    ELEMENTARY, INTERMEDIATE, ADVANCED, UNKNOWN
}