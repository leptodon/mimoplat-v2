package ru.mimobaka.mimoplat_v3.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.mimobaka.mimoplat_v3.data.local.dao.PointDao
import ru.mimobaka.mimoplat_v3.data.local.model.PointDB

@Database(entities = arrayOf(PointDB::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun PointDao(): PointDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? =null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "AppDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}