package com.template.app.remote

import com.template.app.remote.models.RemoteData
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {
    @GET("users/{user}/repos")
    suspend fun getRepos(
        @Path("user") user: String
    ): List<RemoteData>

    /* @GET("live?format=1")
    suspend fun getExchangeRate(
        @Query("access_key") apiKey: String,
        @Query("from") inputCurrency: String,
        @Query("currencies") outputCurrencies: String
    ): Response<CurrencyLayerResponse>*/
}