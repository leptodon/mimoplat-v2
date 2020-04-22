package ru.mimobaka.mimoplat_v3.model

data class Point(
    val id: Int,
    val name: String = "",
    val url: String = "",
    val address: String = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val regionId: Int = 0,
    val regionName: String = ""
)