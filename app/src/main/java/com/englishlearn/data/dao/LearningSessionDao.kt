package com.englishlearn.data.dao

import androidx.room.*
import com.englishlearn.data.entities.LearningSession
import kotlinx.coroutines.flow.Flow

@Dao
interface LearningSessionDao {
    @Query("SELECT * FROM learning_sessions ORDER BY startTime DESC")
    fun getAllSessions(): Flow<List<LearningSession>>
    
    @Query("SELECT * FROM learning_sessions ORDER BY startTime DESC")
    suspend fun getAllSessionsList(): List<LearningSession>

    @Query("SELECT * FROM learning_sessions WHERE documentId = :documentId ORDER BY startTime DESC")
    fun getSessionsByDocument(documentId: String): Flow<List<LearningSession>>

    @Query("SELECT * FROM learning_sessions WHERE startTime >= :startTime AND startTime <= :endTime ORDER BY startTime DESC")
    fun getSessionsByDateRange(startTime: Long, endTime: Long): Flow<List<LearningSession>>

    @Query("SELECT SUM(duration) FROM learning_sessions WHERE startTime >= :startTime")
    suspend fun getTotalStudyTimeFromDate(startTime: Long): Long?

    @Query("SELECT AVG(duration) FROM learning_sessions WHERE startTime >= :startTime")
    suspend fun getAverageStudyTimeFromDate(startTime: Long): Long?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: LearningSession)

    @Update
    suspend fun updateSession(session: LearningSession)

    @Delete
    suspend fun deleteSession(session: LearningSession)
}