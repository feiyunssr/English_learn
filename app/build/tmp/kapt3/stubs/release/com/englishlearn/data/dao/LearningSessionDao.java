package com.englishlearn.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0013\u001a\u00020\u0014H\'J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0018"}, d2 = {"Lcom/englishlearn/data/dao/LearningSessionDao;", "", "deleteSession", "", "session", "Lcom/englishlearn/data/entities/LearningSession;", "(Lcom/englishlearn/data/entities/LearningSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSessions", "Lkotlinx/coroutines/flow/Flow;", "", "getAllSessionsList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAverageStudyTimeFromDate", "", "startTime", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionsByDateRange", "endTime", "getSessionsByDocument", "documentId", "", "getTotalStudyTimeFromDate", "insertSession", "updateSession", "app_release"})
@androidx.room.Dao
public abstract interface LearningSessionDao {
    
    @androidx.room.Query(value = "SELECT * FROM learning_sessions ORDER BY startTime DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.LearningSession>> getAllSessions();
    
    @androidx.room.Query(value = "SELECT * FROM learning_sessions ORDER BY startTime DESC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllSessionsList(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.englishlearn.data.entities.LearningSession>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM learning_sessions WHERE documentId = :documentId ORDER BY startTime DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.LearningSession>> getSessionsByDocument(@org.jetbrains.annotations.NotNull
    java.lang.String documentId);
    
    @androidx.room.Query(value = "SELECT * FROM learning_sessions WHERE startTime >= :startTime AND startTime <= :endTime ORDER BY startTime DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.LearningSession>> getSessionsByDateRange(long startTime, long endTime);
    
    @androidx.room.Query(value = "SELECT SUM(duration) FROM learning_sessions WHERE startTime >= :startTime")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTotalStudyTimeFromDate(long startTime, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT AVG(duration) FROM learning_sessions WHERE startTime >= :startTime")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAverageStudyTimeFromDate(long startTime, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertSession(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.LearningSession session, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateSession(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.LearningSession session, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteSession(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.LearningSession session, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}