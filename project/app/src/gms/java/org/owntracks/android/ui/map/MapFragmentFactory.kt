package org.owntracks.android.ui.map

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import org.owntracks.android.data.repos.LocationRepo
import org.owntracks.android.support.Preferences
import org.owntracks.android.ui.map.osm.OSMMapFragment
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * An [FragmentFactory] instance that can either provide a GoogleMap fragment or an OSM fragment
 * depending on whether the use-osm-map preference is set.
 *
 * @property locationRepo required to create [MapFragment]
 * @property preferences can be used to decide what implementation of [MapFragment] should be used.
 */
@Singleton
class MapFragmentFactory @Inject constructor(
    private val locationRepo: LocationRepo,
    private val preferences: Preferences
) : FragmentFactory() {
    var mapLocationSource: MapLocationSource? = null
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        Timber.d("Instantiating Fragment for $className")
        return if (MapFragment::class.java.isAssignableFrom(classLoader.loadClass(className))) {
            if (preferences.experimentalFeatures.contains(Preferences.EXPERIMENTAL_FEATURE_USE_OSM_MAP)) {
                OSMMapFragment(locationRepo, mapLocationSource!!)
            } else {
                GoogleMapFragment(locationRepo, mapLocationSource!!)
            }
        } else {
            super.instantiate(classLoader, className)
        }
    }
}