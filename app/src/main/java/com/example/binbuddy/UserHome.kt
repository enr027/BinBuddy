package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentUserHomeBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment


class UserHome : Fragment(R.layout.fragment_user_home), OnMapReadyCallback {
    private var mGoogleMap: GoogleMap? = null

    private lateinit var binding: FragmentUserHomeBinding
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val mapFragment = childFragmentManager
                .findFragmentById(R.id.mapFragment2) as SupportMapFragment
            mapFragment.getMapAsync(this)

            binding = FragmentUserHomeBinding.bind(view)
            binding.imageButton8.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.navigateToFAQ)
            }

            binding.imageButton7.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.navigateToCalendarUser)
            }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
    }
}