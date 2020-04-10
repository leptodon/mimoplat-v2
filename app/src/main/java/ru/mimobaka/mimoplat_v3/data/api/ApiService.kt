package ru.mimobaka.mimoplat_v3.data.api

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.mimobaka.mimoplat_v3.data.model.NetworkResponse

interface ApiService {
    @GET("list")
    suspend fun getResponses(@Query("purchaseToken") token: String?): NetworkResponse
}
