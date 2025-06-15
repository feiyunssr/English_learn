package com.englishlearn.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "learning_sessions")
data class LearningSession(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val documentId: String,
    val startTime: Long,
    val endTime: Long? = null,
    val duration: Long = 0L,
    val wordsLookedUp: Int = 0,
    val translationsRequested: Int = 0,
    val pagesRead: Int = 0,
    val newVocabularyLearned: Int = 0,
    val createdAt: Long = System.currentTimeMillis()
)