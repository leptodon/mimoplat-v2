package ru.mimobaka.mimoplat_v3.ui.map

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.gms.location.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.osmdroid.bonuspack.clustering.RadiusMarkerClusterer
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.XYTileSource
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.ScaleBarOverlay
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import ru.mimobaka.mimoplat_v3.App
import ru.mimobaka.mimoplat_v3.R
import ru.mimobaka.mimoplat_v3.model.Point


class MapFragment : Fragment(), CoroutineScope by MainScope() {
    private lateinit var map: MapView
    private lateinit var controller: MapController
    private lateinit var mLocationOverlay: MyLocationNewOverlay
    private lateinit var poiMarkers: RadiusMarkerClusterer
    private lateinit var clusterIconD: Drawable
    private val mapViewModel by viewModel<MapViewModel>()
    private lateinit var scaleBar: ScaleBarOverlay
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private var currentLocation: Location? = null
    private var icon: Bitmap? = null
    private var pointsList = ArrayList<Point>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Configuration.getInstance()
            .load(context, PreferenceManager.getDefaultSharedPreferences(context));
        val root = inflater.inflate(R.layout.fragment_map, container, false)

        map = root.findViewById(R.id.map)
        mLocationOverlay = MyLocationNewOverlay(map)
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(App.context)
        controller = MapController(map)
        poiMarkers = RadiusMarkerClusterer(this.context)
        clusterIconD = resources.getDrawable(R.drawable.cluster)
        poiMarkers.setIcon(clusterIconD.toBitmap())
        scaleBar = ScaleBarOverlay(map)
        scaleBar.setScaleBarOffset(20, 10)
        map.overlays.add(scaleBar)

        mLocationOverlay.enableMyLocation()
//        icon = BitmapFactory.decodeResource(resources, R.drawable.point_24px)
//        mLocationOverlay.setDirectionArrow(icon, icon)

        mapViewModel.getResponse()
        initMap()
        observers()
        return root
    }

    private fun observers() {
        mapViewModel.pointsList.observe(this, Observer {
            pointsList.addAll(it)
            setMarkers()
        })
    }
    private fun setMarkers() {
        var marker: Marker
        for (p: Point in pointsList) {
            marker = Marker(map)
            marker.icon = getDrawable(requireContext(), R.drawable.point_icon)
            marker.position = GeoPoint(p.lon, p.lat)
            poiMarkers.add(marker)
        }
    }

    @SuppressLint("MissingPermission")
    private fun initMap() = launch {

        map.setTileSource(
            XYTileSource(
                "Sputnik",
                1,
                18,
                512, // по умолчанию 256
                ".png",
                arrayOf("http://tilessputnik.ru/")
            )
        )

        map.setMultiTouchControls(true)
//      map.isTilesScaledToDpi = true

        map.zoomController.activate()
        controller.setZoom(15)

        map.overlays.add(mLocationOverlay)
        map.overlays.add(poiMarkers)

        mFusedLocationClient.lastLocation.addOnCompleteListener { task ->
            currentLocation = task.result
            if (currentLocation == null) {
                requestNewLocationData()
                Log.d("LOCATION_NEW", currentLocation.toString())
            } else {
                controller.setCenter(GeoPoint(currentLocation))
            }
            Log.d("LOCATION_MAIN", currentLocation.toString())
        }

        mLocationOverlay.isDrawAccuracyEnabled = true


        var marker: Marker
        for (p: Point in pointsList) {
            marker = Marker(map)
            marker.icon = getDrawable(requireContext(), R.drawable.point_icon)
            marker.position = GeoPoint(p.lon, p.lat)
            poiMarkers.add(marker)
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        var mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(App.context)
        mFusedLocationClient!!.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            var mLastLocation: Location = locationResult.lastLocation
        }
    }
}
