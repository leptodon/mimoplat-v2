package ru.mimobaka.mimoplat_v3.data.network.repository

import ru.mimobaka.mimoplat_v3.data.network.model.NetworkResponse

interface NWRepository {
    suspend fun getResponse(token:String):NetworkResponse

}
