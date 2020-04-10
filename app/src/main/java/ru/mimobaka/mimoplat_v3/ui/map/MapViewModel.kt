package ru.mimobaka.mimoplat_v3.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import ru.mimobaka.mimoplat_v3.data.repository.NetworkRepository

class MapViewModel : ViewModel() {
    val repository: NetworkRepository = NetworkRepository()
    fun getResponse() = liveData(Dispatchers.IO) {
        val retrivedNetworkResponse = repository.getResponse("1111111555555")
        emit(retrivedNetworkResponse)
    }
}
