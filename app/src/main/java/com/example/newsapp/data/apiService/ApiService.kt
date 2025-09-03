package com.example.newsapp.data.apiService

import retrofit2.http.GET
import com.example.newsapp.data.model.ApiResponse
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")

    suspend fun getHeadLines (
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "7691d7968a57436ab44fc2c6e468b59b"
    ): ApiResponse

    @GET("everything")
    suspend fun getEverything(
        @Query("q") q: String = "us",
        @Query("apiKey") apiKey: String = "7691d7968a57436ab44fc2c6e468b59b"

    ): ApiResponse
}