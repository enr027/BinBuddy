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

/**
 * UserHome is the main page for the user where they will be able to move to all other parts of the app
 */
class UserHome : Fragment(R.layout.fragment_user_home), OnMapReadyCallback {
    // create instance of google maps
    private var mGoogleMap: GoogleMap? = null

    private lateinit var database : DatabaseReference // reference to database
    private lateinit var binding: FragmentUserHomeBinding
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            //initialize the google maps for the user to see
            val mapFragment = childFragmentManager
                .findFragmentById(R.id.mapFragment2) as SupportMapFragment
            mapFragment.getMapAsync(this)

            binding = FragmentUserHomeBinding.bind(view)

            // listen to when user add new job
            binding.addJob.setOnClickListener {

                //get instance of the jobs database
                database = FirebaseDatabase.getInstance().getReference("Jobs")

                //store all information the user entered for their job requests
                val trashType = binding.etTrash.text.toString()
                val amount = binding.etAmount.text.toString()
                val datePickUp = binding.etDate.text.toString()
                val address = binding.etAddress.text.toString()

                // make sure all fields are not empty
                if (binding.etTrash.text != null && binding.etAmount.text != null
                    && binding.etDate.text != null && binding.etAddress.text != null
                ) {

                    // create a Jobdata object to store all fields
                    val JobData = JobData(trashType, amount, datePickUp, address)

                    // enter the job data into the database to be read later by the company
                    database.child(address).setValue(JobData).addOnSuccessListener {

                        //Clear the fields
                        binding.etTrash.text!!.clear()
                        binding.etAmount.text!!.clear()
                        binding.etDate.text!!.clear()
                        binding.etAddress.text!!.clear()
                    }
                }
            }

            // navigate to the FAQ fragment
                binding.imageButton8.setOnClickListener {
                    Navigation.findNavController(view).navigate(R.id.navigateToFAQ)
                }

            //navigate to the the calendar fragment
                binding.imageButton7.setOnClickListener {
                    Navigation.findNavController(view).navigate(R.id.navigateToCalendarUser)
                }

            //navigate to the the user notifications
                binding.imageButton6.setOnClickListener {
                    Navigation.findNavController(view).navigate(R.id.navigateToNotificationsUser)
                }

            //navigate to the user account menu
                binding.imageButton.setOnClickListener {
                    Navigation.findNavController(view).navigate(R.id.navigateToUserAccountMenu)
                }
            }

    // over the onMaoReady function to create the google maps
            override fun onMapReady(googleMap: GoogleMap) {
                mGoogleMap = googleMap
            }
        }
