package ru.mimobaka.mimoplat_v3.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Points")
data class PointDB (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val latitude: Double,
    val longitude: Double
)