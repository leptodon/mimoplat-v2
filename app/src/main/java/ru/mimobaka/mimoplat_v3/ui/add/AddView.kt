package ru.mimobaka.mimoplat_v3.ui.add

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import ru.mimobaka.mimoplat_v3.R
import ru.mimobaka.mimoplat_v3.ui.map.MapView
import ru.mimobaka.mimoplat_v3.ui.settings.SettingsView

class AddView:Controller(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(R.layout.activity_add, container, false)
        view.findViewById<BottomNavigationItemView>(R.id.map).setOnClickListener{
            router.pushController(
                RouterTransaction.with(MapView()))
        }
        view.findViewById<BottomNavigationItemView>(R.id.add_to_map).setOnClickListener{
            router.pushController(
                RouterTransaction.with(AddView()))
        }
        view.findViewById<BottomNavigationItemView>(R.id.settings).setOnClickListener{
            router.pushController(
                RouterTransaction.with(SettingsView()))
        }
        return view
    }
}
