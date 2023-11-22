package com.example.binbuddy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCompanyHomeBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

/**
 * Company Home sets up the Company Home which is the main page the company will use
 */
class CompanyHome : Fragment(R.layout.fragment_company_home), OnMapReadyCallback {
    private lateinit var binding: FragmentCompanyHomeBinding
    // google maps variable to set up google maps
    private var mGoogleMap:GoogleMap? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCompanyHomeBinding.bind(view)
        // set up the google map fragment to display the map for the company
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // button listener navigate to company notification
        binding.imageButton3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.companyHomeToCompanyNotifications)
        }

        // button listener navigate to company calendar
        binding.imageButton4.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.companyHomeToCompanyCalendar)
        }

        // company listener navigate to company account
        binding.imageButton2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.companyHomeToCompanyAccount)
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
    }
}