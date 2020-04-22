package ru.mimobaka.mimoplat_v3.ui.map

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.mimobaka.mimoplat_v3.dataSource.network.repository.NetworkRepository
import ru.mimobaka.mimoplat_v3.model.Point
import ru.mimobaka.mimoplat_v3.useCases.local.DatabaseRepository
import ru.mimobaka.mimoplat_v3.model.Result
import ru.mimobaka.mimoplat_v3.dataSource.network.mappers.NetworkPointMapper
import ru.mimobaka.mimoplat_v3.utills.SingleLiveData

class MapViewModel(
    private val database: DatabaseRepository,
    private val networkResponse: NetworkRepository
) : ViewModel() {

    val pointsList = SingleLiveData<List<Point>>()

    fun getResponse() = viewModelScope.launch {

        when (val result = networkResponse.getResponse("1111111555555")) {
            is Result.Success -> {
                pointsList.postValue(result.data.points?.map { NetworkPointMapper.fromNetwork(it) })
            }
            is Result.Error -> {
                val errMessage = result.message
                Log.e("NETWORK", errMessage)
            }
        }
    }
}
