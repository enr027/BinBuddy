package com.example.binbuddy

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCreateAccountBinding
import com.google.firebase.auth.FirebaseAuth

class CreateAccountFragment : Fragment(R.layout.fragment_create_account) {

    private lateinit var binding: FragmentCreateAccountBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateAccountBinding.bind(view)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.butNewAcc.setOnClickListener {
            val email = binding.EtEmail.text.toString()
            val password = binding.EtPassWord.text.toString()

            if (binding.EtEmail.text.isNotBlank() && binding.EtPassWord.text.isNotBlank() &&
                binding.EtEnterFirstName.text.isNotBlank() && binding.EtEnterLastName.text.isNotBlank()
                && binding.EtEnterDirection.text.isNotBlank() && binding.EtNumberOfBins.text.isNotBlank()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful) {
                        Navigation.findNavController(view).navigate(R.id.navigateBackToLogin)
                    }
                }
            }else{
                Toast.makeText(context,"Please fill out all fields",Toast.LENGTH_LONG).show()
            }
        }
    }
}