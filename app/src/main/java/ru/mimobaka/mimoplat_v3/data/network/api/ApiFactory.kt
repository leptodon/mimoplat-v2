package ru.mimobaka.mimoplat_v3.data.network.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {

    private var API_BASE_URL = "https://mimobaka.ru/mimoplata/api/v1/"

    fun create(): ApiService {
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL) // Базовый URL
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}
