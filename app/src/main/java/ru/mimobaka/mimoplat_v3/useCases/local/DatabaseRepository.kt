package ru.mimobaka.mimoplat_v3.useCases.local

import ru.mimobaka.mimoplat_v3.model.Point

interface DatabaseRepository {

    suspend fun insert(points: List<Point>)

    suspend fun getAll():List<Point>

    suspend fun deleteAll()
}