package ru.mimobaka.mimoplat_v3.data.repository

import ru.mimobaka.mimoplat_v3.data.model.NetworkResponse

interface Repository {
    suspend fun getResponse(token:String):NetworkResponse
}
