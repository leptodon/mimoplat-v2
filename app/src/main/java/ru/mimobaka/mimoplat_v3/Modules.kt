package ru.mimobaka.mimoplat_v3

import android.app.Application
import androidx.room.Room
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mimobaka.mimoplat_v3.dataSource.local.AppDatabase
import ru.mimobaka.mimoplat_v3.dataSource.local.DatabaseRepositoryImpl
import ru.mimobaka.mimoplat_v3.dataSource.network.api.ApiService
import ru.mimobaka.mimoplat_v3.ui.map.MapViewModel
import ru.mimobaka.mimoplat_v3.useCases.local.DatabaseRepository
import java.util.concurrent.TimeUnit

val dataSourceModule = module {

    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "mimoplat")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { provideDatabase(androidApplication()) }

    single<DatabaseRepositoryImpl>()
    factory<DatabaseRepository> { get<DatabaseRepositoryImpl>() }

}

val networkModule = module {

    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://mimobaka.ru/mimoplata/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(
                OkHttpClient()
                    .newBuilder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .build()
            )
            .build()
    }

    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    single { provideRetrofit() }

    single { provideApiService(get()) }
}

val viewModelModule = module {

    viewModel<MapViewModel>()
}