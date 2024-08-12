package com.example.usstatesapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.usstatesapp.databinding.ActivityMapBinding
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController

class MapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapBinding

    companion object {
        private const val EXTRA_STATE = "extra_state"
        fun newIntent(context: Context, state: State): Intent {
            return Intent(context, MapActivity::class.java).apply {
                putExtra(EXTRA_STATE, state)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val state = intent.getParcelableExtra<State>(EXTRA_STATE)
        state?.let {
            setupToolbar(it.stateName)
            setupMap(it)
        }

        binding.fabBack.setOnClickListener {
            finish()
        }
    }

    private fun setupToolbar(stateName: String) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = stateName
        }
    }

    private fun setupMap(state: State) {
        Configuration.getInstance().load(applicationContext, getPreferences(MODE_PRIVATE))

        binding.mapView.apply {
            setTileSource(TileSourceFactory.MAPNIK)
            setMultiTouchControls(true)
            zoomController.setVisibility(CustomZoomButtonsController.Visibility.ALWAYS)

            controller.setZoom(7.0)
            controller.setCenter(getStateCoordinates(state.stateName))
        }
    }

    private fun getStateCoordinates(stateName: String): GeoPoint {
        return when (stateName) {
            "Alabama" -> GeoPoint(32.3182, -86.9023)
            "Alaska" -> GeoPoint(61.3850, -152.2683)
            "Arizona" -> GeoPoint(33.7298, -111.4312)
            "Arkansas" -> GeoPoint(34.9697, -92.3731)
            "California" -> GeoPoint(36.1162, -119.6816)
            "Colorado" -> GeoPoint(39.0598, -105.3111)
            "Connecticut" -> GeoPoint(41.5978, -72.7554)
            "Delaware" -> GeoPoint(39.3185, -75.5071)
            "Florida" -> GeoPoint(27.7663, -81.6868)
            "Georgia" -> GeoPoint(32.1656, -82.9001)
            "Hawaii" -> GeoPoint(21.0943, -157.4983)
            "Idaho" -> GeoPoint(44.2405, -114.4788)
            "Illinois" -> GeoPoint(40.3495, -88.9861)
            "Indiana" -> GeoPoint(39.8494, -86.2583)
            "Iowa" -> GeoPoint(42.0115, -93.2105)
            "Kansas" -> GeoPoint(38.5266, -96.7265)
            "Kentucky" -> GeoPoint(37.6681, -84.6701)
            "Louisiana" -> GeoPoint(31.1695, -91.8678)
            "Maine" -> GeoPoint(44.6939, -69.3819)
            "Maryland" -> GeoPoint(39.0639, -76.8021)
            "Massachusetts" -> GeoPoint(42.2302, -71.5301)
            "Michigan" -> GeoPoint(43.3266, -84.5361)
            "Minnesota" -> GeoPoint(45.6945, -93.9002)
            "Mississippi" -> GeoPoint(32.7416, -89.6787)
            "Missouri" -> GeoPoint(38.4561, -92.2884)
            "Montana" -> GeoPoint(46.9219, -110.4544)
            "Nebraska" -> GeoPoint(41.1254, -98.2681)
            "Nevada" -> GeoPoint(38.3135, -117.0554)
            "New Hampshire" -> GeoPoint(43.4525, -71.5639)
            "New Jersey" -> GeoPoint(40.2989, -74.5210)
            "New Mexico" -> GeoPoint(34.8405, -106.2485)
            "New York" -> GeoPoint(42.1657, -74.9481)
            "North Carolina" -> GeoPoint(35.6301, -79.8064)
            "North Dakota" -> GeoPoint(47.5289, -99.7840)
            "Ohio" -> GeoPoint(40.3888, -82.7649)
            "Oklahoma" -> GeoPoint(35.5653, -96.9289)
            "Oregon" -> GeoPoint(44.5720, -122.0709)
            "Pennsylvania" -> GeoPoint(40.5908, -77.2098)
            "Rhode Island" -> GeoPoint(41.6809, -71.5118)
            "South Carolina" -> GeoPoint(33.8569, -80.9450)
            "South Dakota" -> GeoPoint(44.2998, -99.4388)
            "Tennessee" -> GeoPoint(35.7478, -86.6923)
            "Texas" -> GeoPoint(31.0545, -97.5635)
            "Utah" -> GeoPoint(40.1500, -111.8624)
            "Vermont" -> GeoPoint(44.0459, -72.7107)
            "Virginia" -> GeoPoint(37.7693, -78.1700)
            "Washington" -> GeoPoint(47.3826, -120.4472)
            "West Virginia" -> GeoPoint(38.5976, -80.4549)
            "Wisconsin" -> GeoPoint(44.2685, -89.6165)
            "Wyoming" -> GeoPoint(42.7559, -107.3024)
            "District of Columbia" -> GeoPoint(38.9072, -77.0369)
            "Puerto Rico" -> GeoPoint(18.2208, -66.5901)
            else -> GeoPoint(37.0902, -95.7129) // Center of USA as default
        }
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }
}