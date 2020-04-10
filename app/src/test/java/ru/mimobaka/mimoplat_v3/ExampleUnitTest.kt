package ru.mimobaka.mimoplat_v3

import org.junit.Test
import ru.mimobaka.mimoplat_v3.data.repository.NetworkRepository

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val repository: NetworkRepository = NetworkRepository()

    @Test
    suspend fun showResponse() {
        val retrivedNetworkResponse = repository.getResponseNW("1111111555555")
        retrivedNetworkResponse.points
        print(retrivedNetworkResponse.points.toString())
    }
}
