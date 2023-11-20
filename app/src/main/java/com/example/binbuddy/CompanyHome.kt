package com.example.binbuddy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCompanyHomeBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment


class CompanyHome : Fragment(R.layout.fragment_company_home), OnMapReadyCallback {
    private lateinit var binding: FragmentCompanyHomeBinding
    private var mGoogleMap:GoogleMap? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCompanyHomeBinding.bind(view)
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.imageButton3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.companyHomeToCompanyNotifications)
        }

        binding.imageButton4.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.companyHomeToCompanyCalendar)
        }

        binding.imageButton2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.companyHomeToCompanyAccount)
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
    }
}