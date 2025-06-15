package com.englishlearn.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0012\u001a\u00020\tH\'J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/englishlearn/data/dao/TranslationDao;", "", "deleteTranslation", "", "translation", "Lcom/englishlearn/data/entities/Translation;", "(Lcom/englishlearn/data/entities/Translation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTranslationById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTranslations", "Lkotlinx/coroutines/flow/Flow;", "", "getBookmarkedTranslations", "getTranslationByText", "originalText", "getTranslationsByDocument", "documentId", "insertTranslation", "updateBookmarkStatus", "isBookmarked", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTranslation", "app_release"})
@androidx.room.Dao
public abstract interface TranslationDao {
    
    @androidx.room.Query(value = "SELECT * FROM translations ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.Translation>> getAllTranslations();
    
    @androidx.room.Query(value = "SELECT * FROM translations WHERE originalText = :originalText")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTranslationByText(@org.jetbrains.annotations.NotNull
    java.lang.String originalText, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.englishlearn.data.entities.Translation> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM translations WHERE isBookmarked = 1 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.Translation>> getBookmarkedTranslations();
    
    @androidx.room.Query(value = "SELECT * FROM translations WHERE documentId = :documentId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.Translation>> getTranslationsByDocument(@org.jetbrains.annotations.NotNull
    java.lang.String documentId);
    
    @androidx.room.Query(value = "UPDATE translations SET isBookmarked = :isBookmarked WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateBookmarkStatus(@org.jetbrains.annotations.NotNull
    java.lang.String id, boolean isBookmarked, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertTranslation(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.Translation translation, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateTranslation(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.Translation translation, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTranslation(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.Translation translation, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM translations WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTranslationById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}