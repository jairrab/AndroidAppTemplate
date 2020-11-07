package com.template.app.remote.retrofit

import com.template.app.remote.BuildConfig
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

    fun getApiClient(): GithubApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(getOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(GithubApi::class.java)

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor())
            //.addInterceptor(cacheInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    private fun loggingInterceptor() =
        HttpLoggingInterceptor().apply { level = if (BuildConfig.DEBUG) BODY else NONE }
}

