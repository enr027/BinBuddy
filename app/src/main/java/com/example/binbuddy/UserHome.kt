package com.example.binbuddy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentUserHomeBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.firebase.database.DatabaseReference


class UserHome : Fragment(R.layout.fragment_user_home), OnMapReadyCallback {
    private var mGoogleMap: GoogleMap? = null

    private lateinit var binding: FragmentUserHomeBinding
    private lateinit var database : DatabaseReference
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

            binding.imageButton6.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.navigateToNotificationsUser)
            }

            binding.imageButton.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.navigateToUserAccountMenu)
            }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
    }
}