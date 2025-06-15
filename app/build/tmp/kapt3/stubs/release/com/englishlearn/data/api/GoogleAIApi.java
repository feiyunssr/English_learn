package com.englishlearn.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/englishlearn/data/api/GoogleAIApi;", "", "generateContent", "Lcom/englishlearn/data/api/GoogleAIResponse;", "model", "", "apiKey", "request", "Lcom/englishlearn/data/api/GoogleAIRequest;", "(Ljava/lang/String;Ljava/lang/String;Lcom/englishlearn/data/api/GoogleAIRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface GoogleAIApi {
    
    @retrofit2.http.POST(value = "v1beta/models/{model}:generateContent")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object generateContent(@retrofit2.http.Path(value = "model")
    @org.jetbrains.annotations.NotNull
    java.lang.String model, @retrofit2.http.Header(value = "x-goog-api-key")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.englishlearn.data.api.GoogleAIRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.englishlearn.data.api.GoogleAIResponse> $completion);
}