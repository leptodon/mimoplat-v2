package ru.mimobaka.mimoplat_v3.dataSource.local

import ru.mimobaka.mimoplat_v3.dataSource.local.mappers.LocalPointMapper
import ru.mimobaka.mimoplat_v3.model.Point
import ru.mimobaka.mimoplat_v3.useCases.local.DatabaseRepository

class DatabaseRepositoryImpl(private val database: AppDatabase) : DatabaseRepository {

    override suspend fun insert(points: List<Point>) {
        database.pointDao().insertPoint(points.map { LocalPointMapper.toDto(it) })
    }

    override suspend fun getAll(): List<Point> {
        return database.pointDao().getAll().map { LocalPointMapper.fromDto(it) }
    }

    override suspend fun deleteAll() {
        database.pointDao().deleteAll()
    }

}