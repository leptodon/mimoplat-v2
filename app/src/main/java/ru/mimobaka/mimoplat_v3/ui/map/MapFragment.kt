package ru.mimobaka.mimoplat_v3.ui.map

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.XYTileSource
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.ScaleBarOverlay
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import ru.mimobaka.mimoplat_v3.R


class MapFragment : Fragment(), CoroutineScope by MainScope() {
    private lateinit var map: MapView
    private lateinit var controller: IMapController
    private lateinit var mLocationOverlay: MyLocationNewOverlay
//    private lateinit var poiMarkers: RadiusMarkerClusterer
//    private lateinit var clusterIconD: Drawable
    private lateinit var mapViewModel: MapViewModel
    private lateinit var scaleBar: ScaleBarOverlay
    private lateinit var dm: DisplayMetrics

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        Configuration.getInstance().load(context, PreferenceManager.getDefaultSharedPreferences(context));
        mapViewModel = ViewModelProvider.NewInstanceFactory().create(MapViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_map, container, false)
        dm = context!!.resources.displayMetrics
        map = root.findViewById(R.id.map)
        mLocationOverlay = MyLocationNewOverlay(map)
        controller = MapController(map)

        map.zoomController.setVisibility(CustomZoomButtonsController.Visibility.ALWAYS)
        map.setMultiTouchControls(true)
        scaleBar = ScaleBarOverlay(map)
        scaleBar.setCentred(true)
        scaleBar.setScaleBarOffset(dm.widthPixels / 2, 10)
        map.overlays.add(scaleBar)
        initMap()
        return root
    }

    private fun initMap() = launch{
        map.setTileSource(
            XYTileSource(
                "Sputnik",
                1,
                18,
                256,
                ".png",
                arrayOf("http://tilessputnik.ru/")
            )
        )


        controller.setZoom(9.5)
        controller.setCenter(mLocationOverlay.myLocation)
//        mapViewModel.getResponse().observe(viewLifecycleOwner, Observer {
//            var marker: Marker
//            for (p: PointNW in it.points!!){
//                marker = Marker(map)
//                marker.icon = getDrawable(context!!, R.drawable.point_icon)
//                marker.position = GeoPoint(p.lon!!, p.lat!!)
//                poiMarkers.add(marker)
//            }
//        })
    }
}
