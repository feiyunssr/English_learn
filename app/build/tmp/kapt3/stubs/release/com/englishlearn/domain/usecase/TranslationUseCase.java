package com.englishlearn.domain.usecase;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ8\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0012"}, d2 = {"Lcom/englishlearn/domain/usecase/TranslationUseCase;", "", "context", "Landroid/content/Context;", "googleAIApi", "Lcom/englishlearn/data/api/GoogleAIApi;", "vocabularyRepository", "Lcom/englishlearn/domain/repository/VocabularyRepository;", "(Landroid/content/Context;Lcom/englishlearn/data/api/GoogleAIApi;Lcom/englishlearn/domain/repository/VocabularyRepository;)V", "translateText", "Lkotlin/Result;", "Lcom/englishlearn/data/entities/Translation;", "text", "", "sourceLanguage", "targetLanguage", "translateText-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class TranslationUseCase {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.data.api.GoogleAIApi googleAIApi = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.domain.repository.VocabularyRepository vocabularyRepository = null;
    
    @javax.inject.Inject
    public TranslationUseCase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.englishlearn.data.api.GoogleAIApi googleAIApi, @org.jetbrains.annotations.NotNull
    com.englishlearn.domain.repository.VocabularyRepository vocabularyRepository) {
        super();
    }
}