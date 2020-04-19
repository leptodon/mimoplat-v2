package ru.mimobaka.mimoplat_v3

import org.junit.Test
import ru.mimobaka.mimoplat_v3.data.network.repository.NWRepositoryImpl

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val repositoryImpl: NWRepositoryImpl = NWRepositoryImpl()

    @Test
    suspend fun showResponse() {
        val retrivedNetworkResponse = repositoryImpl.getResponseNW("1111111555555")
        retrivedNetworkResponse.points
        print(retrivedNetworkResponse.points.toString())
    }
}
