package ru.mimobaka.mimoplat_v3.dataSource.local.dto

import androidx.room.Entity

@Entity(tableName = "Points_table", primaryKeys = ["id"])
internal data class PointDto (
    val id: Int,
    val name: String,
    val url: String,
    val address: String,
    val lat: Double,
    val lon: Double,
    val regionId: Int,
    val regionName: String
)