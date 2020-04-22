package ru.mimobaka.mimoplat_v3.dataSource.network.model

data class PointNetwork(
    val id: Int,
    val name: String?,
    val url: String?,
    val address: String?,
    val lat: Double?,
    val lon: Double?,
    val regionId: Int?,
    val regionName: String?
)
