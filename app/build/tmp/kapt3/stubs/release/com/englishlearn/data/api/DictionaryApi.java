package com.englishlearn.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/englishlearn/data/api/DictionaryApi;", "", "getWordDefinition", "Lretrofit2/Response;", "", "Lcom/englishlearn/data/api/DictionaryResponse;", "word", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface DictionaryApi {
    
    @retrofit2.http.GET(value = "entries/en/{word}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getWordDefinition(@retrofit2.http.Path(value = "word")
    @org.jetbrains.annotations.NotNull
    java.lang.String word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.englishlearn.data.api.DictionaryResponse>>> $completion);
}