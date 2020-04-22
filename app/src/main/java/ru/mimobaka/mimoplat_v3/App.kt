package ru.mimobaka.mimoplat_v3

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataSourceModule,
                    networkModule,
                    viewModelModule
                )
            )
        }
    }
}
