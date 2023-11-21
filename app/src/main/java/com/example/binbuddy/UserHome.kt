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
import com.google.firebase.database.FirebaseDatabase


class UserHome : Fragment(R.layout.fragment_user_home), OnMapReadyCallback {
    private var mGoogleMap: GoogleMap? = null

    private lateinit var database : DatabaseReference
    private lateinit var binding: FragmentUserHomeBinding
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val mapFragment = childFragmentManager
                .findFragmentById(R.id.mapFragment2) as SupportMapFragment
            mapFragment.getMapAsync(this)

            binding = FragmentUserHomeBinding.bind(view)

            binding.addJob.setOnClickListener {

                database = FirebaseDatabase.getInstance().getReference("Jobs")

                val trashType = binding.etTrash.text.toString()
                val amount = binding.etAmount.text.toString()
                val datePickUp = binding.etDate.text.toString()
                val address = binding.etAddress.text.toString()

                if (binding.etTrash.text != null && binding.etAmount.text != null
                    && binding.etDate.text != null && binding.etAddress.text != null
                ) {

                    val JobData = JobData(trashType, amount, datePickUp, address)

                    database.child(address).setValue(JobData).addOnSuccessListener {

                        //Clear the fields
                        binding.etTrash.text!!.clear()
                        binding.etAmount.text!!.clear()
                        binding.etDate.text!!.clear()
                        binding.etAddress.text!!.clear()
                    }
                }
            }

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
