package com.englishlearn.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OpenRouterApi {
    @POST("chat/completions")
    suspend fun translateText(
        @Header("Authorization") apiKey: String,
        @Body request: TranslationRequest
    ): Response<TranslationResponse>

    @POST("chat/completions")
    suspend fun summarizeDocument(
        @Header("Authorization") apiKey: String,
        @Body request: SummaryRequest
    ): Response<SummaryResponse>
}

data class TranslationRequest(
    val model: String,
    val messages: List<ChatMessage>,
    val temperature: Double = 0.3,
    val max_tokens: Int = 1000
)

data class SummaryRequest(
    val model: String,
    val messages: List<ChatMessage>,
    val temperature: Double = 0.5,
    val max_tokens: Int = 2000
)

data class ChatMessage(
    val role: String,
    val content: String
)

data class TranslationResponse(
    val choices: List<Choice>
)

data class SummaryResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: ChatMessage
)