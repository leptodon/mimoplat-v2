package ru.mimobaka.mimoplat_v3.dataSource.network.repository

import ru.mimobaka.mimoplat_v3.dataSource.network.model.NetworkResponse
import ru.mimobaka.mimoplat_v3.model.Result

interface NetworkRepository {

    suspend fun getResponse(token:String):Result<NetworkResponse>
}
