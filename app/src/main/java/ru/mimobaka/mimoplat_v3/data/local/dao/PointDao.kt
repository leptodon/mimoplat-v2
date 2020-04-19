package ru.mimobaka.mimoplat_v3.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.mimobaka.mimoplat_v3.data.local.model.PointDB

@Dao
interface PointDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPoint(point: PointDB)

    @Query("DELETE FROM Points")
    suspend fun deleteAll()

    @Query("SELECT * FROM Points")
    fun getPoints(): LiveData<List<PointDB>>
}