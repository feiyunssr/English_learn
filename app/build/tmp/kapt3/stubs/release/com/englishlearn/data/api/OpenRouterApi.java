package com.englishlearn.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/englishlearn/data/api/OpenRouterApi;", "", "summarizeDocument", "Lretrofit2/Response;", "Lcom/englishlearn/data/api/SummaryResponse;", "apiKey", "", "request", "Lcom/englishlearn/data/api/SummaryRequest;", "(Ljava/lang/String;Lcom/englishlearn/data/api/SummaryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translateText", "Lcom/englishlearn/data/api/TranslationResponse;", "Lcom/englishlearn/data/api/TranslationRequest;", "(Ljava/lang/String;Lcom/englishlearn/data/api/TranslationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface OpenRouterApi {
    
    @retrofit2.http.POST(value = "chat/completions")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object translateText(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.englishlearn.data.api.TranslationRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.englishlearn.data.api.TranslationResponse>> $completion);
    
    @retrofit2.http.POST(value = "chat/completions")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object summarizeDocument(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.englishlearn.data.api.SummaryRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.englishlearn.data.api.SummaryResponse>> $completion);
}