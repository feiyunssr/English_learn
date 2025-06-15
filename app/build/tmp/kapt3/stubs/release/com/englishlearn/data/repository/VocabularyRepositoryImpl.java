package com.englishlearn.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u0010H\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u0010H\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u001fJ\u001e\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/englishlearn/data/repository/VocabularyRepositoryImpl;", "Lcom/englishlearn/domain/repository/VocabularyRepository;", "vocabularyDao", "Lcom/englishlearn/data/dao/VocabularyDao;", "(Lcom/englishlearn/data/dao/VocabularyDao;)V", "calculateNextReviewTime", "", "correct", "", "currentTime", "deleteVocabulary", "", "vocabulary", "Lcom/englishlearn/data/entities/Vocabulary;", "(Lcom/englishlearn/data/entities/Vocabulary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllVocabulary", "Lkotlinx/coroutines/flow/Flow;", "", "getBookmarkedVocabulary", "getVocabularyByDocument", "documentId", "", "getVocabularyByWord", "word", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVocabularyForReview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertVocabulary", "updateBookmarkStatus", "id", "isBookmarked", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReviewStats", "updateVocabulary", "app_release"})
public final class VocabularyRepositoryImpl implements com.englishlearn.domain.repository.VocabularyRepository {
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.data.dao.VocabularyDao vocabularyDao = null;
    
    @javax.inject.Inject
    public VocabularyRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.dao.VocabularyDao vocabularyDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.Vocabulary>> getAllVocabulary() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.Vocabulary>> getBookmarkedVocabulary() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.englishlearn.data.entities.Vocabulary>> getVocabularyByDocument(@org.jetbrains.annotations.NotNull
    java.lang.String documentId) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getVocabularyByWord(@org.jetbrains.annotations.NotNull
    java.lang.String word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.englishlearn.data.entities.Vocabulary> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getVocabularyForReview(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.englishlearn.data.entities.Vocabulary>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertVocabulary(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.Vocabulary vocabulary, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateVocabulary(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.Vocabulary vocabulary, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateReviewStats(@org.jetbrains.annotations.NotNull
    java.lang.String id, boolean correct, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateBookmarkStatus(@org.jetbrains.annotations.NotNull
    java.lang.String id, boolean isBookmarked, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteVocabulary(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.entities.Vocabulary vocabulary, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final long calculateNextReviewTime(boolean correct, long currentTime) {
        return 0L;
    }
}