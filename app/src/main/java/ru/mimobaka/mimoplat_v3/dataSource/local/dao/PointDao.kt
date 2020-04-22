package ru.mimobaka.mimoplat_v3.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.mimobaka.mimoplat_v3.dataSource.local.dto.PointDto

@Dao
internal interface PointDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPoint(point: List<PointDto>)

    @Query("DELETE FROM Points_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM Points_table")
    fun getAll(): List<PointDto>
}