package ru.mimobaka.mimoplat_v3.dataSource.network.repository

import android.accounts.NetworkErrorException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import ru.mimobaka.mimoplat_v3.dataSource.network.api.ApiService
import ru.mimobaka.mimoplat_v3.dataSource.network.model.NetworkResponse
import ru.mimobaka.mimoplat_v3.model.Result
import java.lang.Exception

class NetworkRepositoryImpl(private val apiService: ApiService): NetworkRepository {
    suspend fun getResponseNW(token: String) = apiService.getResponses(token)

    override suspend fun getResponse(token: String):Result<NetworkResponse>{
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getResponses("1111111555555")
                Result.Success(response)
            } catch (e: Throwable) {
                val message = when(e){
                    is HttpException -> e.response()?.errorBody()?.string() ?: e.toString()
                    else -> e.message?:e.toString()
                }
                Result.Error(e, message)
            }
        }

    }
}