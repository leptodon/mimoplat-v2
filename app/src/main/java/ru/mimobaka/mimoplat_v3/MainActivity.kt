package ru.mimobaka.mimoplat_v3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.osmdroid.config.Configuration
import org.osmdroid.views.overlay.TilesOverlay


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        val navController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_map, R.id.navigation_settings))

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        Configuration.getInstance().userAgentValue = BuildConfig.APPLICATION_ID

//        navView.setOnNavigationItemSelectedListener{
//            when(it.itemId){
//                R.id.navigation_add -> {
//                    add_popup.visibility = View.VISIBLE
//                    return@setOnNavigationItemSelectedListener true
//                }
//                else -> {
//                    add_popup.visibility = View.INVISIBLE
//                    return@setOnNavigationItemSelectedListener true
//                }
//            }
//        }
//        navView.setOnClickListener{
//            Log.d("ID", it.id.toString())
//            when (it.id) {
//                R.id.add_btn -> {
//                    add_popup.visibility = View.INVISIBLE
//                    Log.d("ACTION", "PRESS ADD BUTTON")
//                }
//            }
//        }
    }
}
