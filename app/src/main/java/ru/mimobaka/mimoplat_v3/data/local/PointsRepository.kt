package ru.mimobaka.mimoplat_v3.data.local

import androidx.lifecycle.LiveData
import ru.mimobaka.mimoplat_v3.data.local.dao.PointDao
import ru.mimobaka.mimoplat_v3.data.local.model.PointDB

class PointsRepository(private val pointDao: PointDao) {
    val allPoint: LiveData<List<PointDB>> = pointDao.getPoints()

    suspend fun insert(pointsList: List<PointDB>) {
        for (p in pointsList) {
            pointDao.insertPoint(p)
        }
    }
}