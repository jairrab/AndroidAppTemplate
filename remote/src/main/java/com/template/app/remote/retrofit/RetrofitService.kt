package com.template.app.remote.retrofit

import com.template.app.remote.GithubApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitService {
    private const val BASE_URL = "https://api.github.com/"

    fun getApiClient(isDebug: Boolean): GithubApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(getOkHttpClient(isDebug))
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(GithubApi::class.java)

    private fun getOkHttpClient(isDebug: Boolean): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor(isDebug))
            //.addInterceptor(cacheInterceptor())
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .build()
    }

    private fun loggingInterceptor(isDebug: Boolean) =
        HttpLoggingInterceptor().apply { level = if (isDebug) BODY else NONE }
}

