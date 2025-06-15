package com.englishlearn.domain.usecase;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J<\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001f"}, d2 = {"Lcom/englishlearn/domain/usecase/DictionaryUseCase;", "", "dictionaryApi", "Lcom/englishlearn/data/api/DictionaryApi;", "vocabularyRepository", "Lcom/englishlearn/domain/repository/VocabularyRepository;", "builtInDictionary", "Lcom/englishlearn/data/dictionary/BuiltInDictionary;", "(Lcom/englishlearn/data/api/DictionaryApi;Lcom/englishlearn/domain/repository/VocabularyRepository;Lcom/englishlearn/data/dictionary/BuiltInDictionary;)V", "calculateFrequency", "", "word", "", "determineDifficulty", "Lcom/englishlearn/data/entities/DifficultyLevel;", "extractAntonyms", "", "dictionaryData", "Lcom/englishlearn/data/api/DictionaryResponse;", "extractAudioUrl", "extractDefinition", "extractExamples", "extractPhonetic", "extractSynonyms", "lookupWord", "Lkotlin/Result;", "Lcom/englishlearn/data/entities/Vocabulary;", "documentId", "context", "lookupWord-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class DictionaryUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.data.api.DictionaryApi dictionaryApi = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.domain.repository.VocabularyRepository vocabularyRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.englishlearn.data.dictionary.BuiltInDictionary builtInDictionary = null;
    
    @javax.inject.Inject
    public DictionaryUseCase(@org.jetbrains.annotations.NotNull
    com.englishlearn.data.api.DictionaryApi dictionaryApi, @org.jetbrains.annotations.NotNull
    com.englishlearn.domain.repository.VocabularyRepository vocabularyRepository, @org.jetbrains.annotations.NotNull
    com.englishlearn.data.dictionary.BuiltInDictionary builtInDictionary) {
        super();
    }
    
    private final java.lang.String extractDefinition(com.englishlearn.data.api.DictionaryResponse dictionaryData) {
        return null;
    }
    
    private final java.lang.String extractPhonetic(com.englishlearn.data.api.DictionaryResponse dictionaryData) {
        return null;
    }
    
    private final java.lang.String extractAudioUrl(com.englishlearn.data.api.DictionaryResponse dictionaryData) {
        return null;
    }
    
    private final java.util.List<java.lang.String> extractExamples(com.englishlearn.data.api.DictionaryResponse dictionaryData) {
        return null;
    }
    
    private final java.util.List<java.lang.String> extractSynonyms(com.englishlearn.data.api.DictionaryResponse dictionaryData) {
        return null;
    }
    
    private final java.util.List<java.lang.String> extractAntonyms(com.englishlearn.data.api.DictionaryResponse dictionaryData) {
        return null;
    }
    
    private final com.englishlearn.data.entities.DifficultyLevel determineDifficulty(java.lang.String word) {
        return null;
    }
    
    private final int calculateFrequency(java.lang.String word) {
        return 0;
    }
}