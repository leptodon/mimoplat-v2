package ru.mimobaka.mimoplat_v3.dataSource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.mimobaka.mimoplat_v3.dataSource.local.dao.PointDao
import ru.mimobaka.mimoplat_v3.dataSource.local.dto.PointDto

@Database(entities = [PointDto::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    internal abstract fun pointDao(): PointDao
}