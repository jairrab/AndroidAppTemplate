package com.template.app.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("live?format=1")
    suspend fun getExchangeRate(
        @Query("access_key") apiKey: String,
        @Query("from") inputCurrency: String
    ): Response<CurrencyLayerResponse>

    @GET("live?format=1")
    suspend fun getExchangeRate(
        @Query("access_key") apiKey: String,
        @Query("from") inputCurrency: String,
        @Query("currencies") outputCurrencies: String
    ): Response<CurrencyLayerResponse>

    @GET("users/{user}/repos")
    suspend fun listRepos(
        @Path("user") user: String
    ): Response<List<GitHubRepo>>
}