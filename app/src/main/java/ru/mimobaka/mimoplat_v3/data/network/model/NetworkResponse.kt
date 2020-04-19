package ru.mimobaka.mimoplat_v3.data.network.model

data class NetworkResponse(
    val version: String?,
    val points: List<PointNW>?,
    val result: String?,
    val resultCode: String?,
    val resultMessage: String?
)
