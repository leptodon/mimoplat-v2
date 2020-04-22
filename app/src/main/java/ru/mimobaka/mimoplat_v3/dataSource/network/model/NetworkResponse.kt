package ru.mimobaka.mimoplat_v3.dataSource.network.model

data class NetworkResponse(
    val version: String?,
    val points: List<PointNetwork>?,
    val result: String?,
    val resultCode: String?,
    val resultMessage: String?
)
