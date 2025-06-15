package com.englishlearn.data.dictionary;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012R\'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/englishlearn/data/dictionary/BuiltInDictionary;", "", "()V", "englishChineseDictionary", "", "", "Lcom/englishlearn/data/dictionary/DictionaryEntry;", "getEnglishChineseDictionary", "()Ljava/util/Map;", "englishChineseDictionary$delegate", "Lkotlin/Lazy;", "englishEnglishDictionary", "getEnglishEnglishDictionary", "englishEnglishDictionary$delegate", "getDefinition", "word", "lookupWord", "useChineseDictionary", "", "app_release"})
public final class BuiltInDictionary {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy englishChineseDictionary$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy englishEnglishDictionary$delegate = null;
    
    @javax.inject.Inject
    public BuiltInDictionary() {
        super();
    }
    
    private final java.util.Map<java.lang.String, com.englishlearn.data.dictionary.DictionaryEntry> getEnglishChineseDictionary() {
        return null;
    }
    
    private final java.util.Map<java.lang.String, com.englishlearn.data.dictionary.DictionaryEntry> getEnglishEnglishDictionary() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.englishlearn.data.dictionary.DictionaryEntry lookupWord(@org.jetbrains.annotations.NotNull
    java.lang.String word, boolean useChineseDictionary) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDefinition(@org.jetbrains.annotations.NotNull
    java.lang.String word) {
        return null;
    }
}