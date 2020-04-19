package ru.mimobaka.mimoplat_v3.data.network.repository

import ru.mimobaka.mimoplat_v3.data.network.api.ApiFactory
import ru.mimobaka.mimoplat_v3.data.network.api.ApiService
import ru.mimobaka.mimoplat_v3.data.network.model.NetworkResponse


class NWRepositoryImpl: NWRepository {
    var client: ApiService = ApiFactory.create()
//    fun getResponseNW(token: String): LiveData<NetworkResponse> {
//        val liveData = MutableLiveData<NetworkResponse>()
//
//        client.getResponses(token).enqueue(object : Callback<NetworkResponse> {
//            override fun onResponse(
//                call: Call<NetworkResponse>,
//                response: Response<NetworkResponse>
//            ) {
//                if (response.isSuccessful) {
//                    liveData.value = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<NetworkResponse>, t: Throwable) {
//                t.printStackTrace()
//            }
//        })
//        return liveData
//    }

    suspend fun getResponseNW(token: String) = client.getResponses(token)

    override suspend fun getResponse(token: String):NetworkResponse{
        return client.getResponses(token)
    }
}
