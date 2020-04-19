package ru.mimobaka.mimoplat_v3.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.mimobaka.mimoplat_v3.data.network.model.NetworkResponse

interface ApiService {
    @GET("list")
    suspend fun getResponses(@Query("purchaseToken") token: String?): NetworkResponse
}
