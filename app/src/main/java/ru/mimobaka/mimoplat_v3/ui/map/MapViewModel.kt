package ru.mimobaka.mimoplat_v3.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import ru.mimobaka.mimoplat_v3.data.network.repository.NWRepositoryImpl

class MapViewModel : ViewModel() {
    val repositoryImpl: NWRepositoryImpl = NWRepositoryImpl()
    fun getResponse() = liveData(Dispatchers.IO) {
        val retrivedNetworkResponse = repositoryImpl.getResponse("1111111555555")
        emit(retrivedNetworkResponse)
    }


}
