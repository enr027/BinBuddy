package com.example.binbuddy

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCreateAccountBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateAccountFragment : Fragment(R.layout.fragment_create_account) {

    private lateinit var binding: FragmentCreateAccountBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database : DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateAccountBinding.bind(view)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.butNewAcc.setOnClickListener {
            //Create variables to be used for the firebase realtime database and authentic database
            val email = binding.EtEmail.text.toString()
            val password = binding.EtPassWord.text.toString()
            val firstName = binding.EtEnterFirstName.text.toString()
            val lastName = binding.EtEnterLastName.text.toString()
            val address = binding.EtEnterAddress.text.toString()
            val city = binding.EtCity.text.toString()
            val zip = binding.EtZip.text.toString()
            val userName = email.substringBefore('@')

            //Create database var named Users
            database = FirebaseDatabase.getInstance().getReference("Users")

            //Make sure all fields are not blank and filled out
            if (binding.EtEmail.text.isNotBlank() && binding.EtPassWord.text.isNotBlank() &&
                binding.EtEnterFirstName.text.isNotBlank() && binding.EtEnterLastName.text.isNotBlank()
                && binding.EtEnterAddress.text.isNotBlank() && binding.EtZip.text.isNotBlank()
                && binding.EtCity.text.isNotBlank()
            ) {
                //Create authentic database accepting email and password
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        //Store variables in User data file
                        val User = User(firstName, lastName, address, zip, userName, email, city)
                        //Set the values for the Key which is the user
                        database.child(userName).setValue(User).addOnSuccessListener {

                            //Clear the fields
                            binding.EtEnterFirstName.text.clear()
                            binding.EtEnterLastName.text.clear()
                            binding.EtPassWord.text.clear()
                            binding.EtEmail.text.clear()
                            binding.EtEnterAddress.text.clear()
                            binding.EtCity.text.clear()
                            binding.EtZip.text.clear()

                            //Output success
                            Toast.makeText(context, "Successfully Saved", Toast.LENGTH_SHORT).show()

                            //Navigate back to login screen
                            Navigation.findNavController(view).navigate(R.id.navigateBackToLogin)

                            //If failed display failure
                        }.addOnFailureListener {
                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}