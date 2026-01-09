package com.example.newsapp.data.apiService

import retrofit2.http.GET
import com.example.newsapp.data.model.ApiResponse
import retrofit2.http.Query
import com.example.newsapp.BuildConfig

interface ApiService {
    @GET("top-headlines")

    suspend fun getHeadLines (
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): ApiResponse

    @GET("everything")
    suspend fun getEverything(
        @Query("q") q: String = "us",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY

    ): ApiResponse
}
