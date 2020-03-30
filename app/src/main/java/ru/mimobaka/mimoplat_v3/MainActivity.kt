package ru.mimobaka.mimoplat_v3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import ru.mimobaka.mimoplat_v3.R
import ru.mimobaka.mimoplat_v3.ui.map.MapView

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container: ViewGroup = findViewById(R.id.root)
        router = Conductor.attachRouter(this, container, savedInstanceState)

        if (!router.hasRootController()) router.setRoot(RouterTransaction.with(MapView()))
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed();
        }
    }
}
