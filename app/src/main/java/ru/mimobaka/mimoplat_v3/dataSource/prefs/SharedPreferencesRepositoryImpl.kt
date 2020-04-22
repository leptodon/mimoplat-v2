package ru.mimobaka.mimoplat_v3.dataSource.prefs

import android.content.Context
import androidx.preference.PreferenceManager
import ru.mimobaka.mimoplat_v3.useCases.prefs.SharedPreferencesRepository
import ru.mimobaka.mimoplat_v3.utills.string

class SharedPreferencesRepositoryImpl(context: Context): SharedPreferencesRepository {

    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    override var versionPointsDatabase: String by prefs.string()

}