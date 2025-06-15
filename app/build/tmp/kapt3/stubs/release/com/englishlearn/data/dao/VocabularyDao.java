package com.englishlearn.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0010\u001a\u00020\tH\'J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ.\u0010\u001c\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006#"}, d2 = {"Lcom/englishlearn/data/dao/VocabularyDao;", "", "deleteVocabulary", "", "vocabulary", "Lcom/englishlearn/data/entities/Vocabulary;", "(Lcom/englishlearn/data/entities/Vocabulary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVocabularyById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllVocabulary", "Lkotlinx/coroutines/flow/Flow;", "", "getBookmarkedVocabulary", "getVocabularyByDocument", "documentId", "getVocabularyByWord", "word", "getVocabularyForReview", "currentTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertVocabulary", "updateBookmarkStatus", "isBookmarked", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReviewStats", "correct", "", "reviewTime", "nextReviewTime", "(Ljava/lang/String;IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateVocabulary", "app_release"})
@androidx.room.Dao
public abstract interface VocabularyDao {
    
    @androidx.room.Query(value = "SELECT * FROM vocabulary ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.Vocabulary>> getAllVocabulary();
    
    @androidx.room.Query(value = "SELECT * FROM vocabulary WHERE word = :word")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getVocabularyByWord(@org.jetbrains.annotations.NotNull
    java.lang.String word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.englishlearn.data.entities.Vocabulary> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM vocabulary WHERE isBookmarked = 1 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.Vocabulary>> getBookmarkedVocabulary();
    
    @androidx.room.Query(value = "SELECT * FROM vocabulary WHERE documentId = :documentId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.Vocabulary>> getVocabularyByDocument(@org.jetbrains.annotations.NotNull
    java.lang.String documentId);
    
    @androidx.room.Query(value = "SELECT * FROM vocabulary WHERE nextReviewAt <= :currentTime ORDER BY nextReviewAt ASC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getVocabularyForReview(long currentTime, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.englishlearn.data.entities.Vocabulary>> $completion);
    
    @androidx.room.Query(value = "UPDATE vocabulary SET reviewCount = reviewCount + 1, correctCount = correctCount + :correct, lastReviewedAt = :reviewTime, nextReviewAt = :nextReviewTime WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateReviewStats(@org.jetbrains.annotations.NotNull
    java.lang.String id, int correct, long reviewTime, long nextReviewTime, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE vocabulary SET isBookmarked = :isBookmarked WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateBookmarkStatus(@org.jetbrains.annotations.NotNull
    java.lang.String id, boolean isBookmarked, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertVocabulary(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.Vocabulary vocabulary, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateVocabulary(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.Vocabulary vocabulary, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteVocabulary(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.Vocabulary vocabulary, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM vocabulary WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteVocabularyById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}