package com.example.binbuddy

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class loginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.butUserLogin.setOnClickListener {
            val email = binding.etLoginEmail.text.toString()
            val password = binding.etLoginPassword.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Navigation.findNavController(view).navigate(R.id.navigateToUserHome)
                    }
                    else
                    {
                        Toast.makeText(context,"Please make a new account", Toast.LENGTH_LONG).show()
                    }
                }
            }else Toast.makeText(context,"Please fill out all fields", Toast.LENGTH_LONG).show()
        }

        binding.butCreateNewAcc.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.navigateToCreateAcc)
        }

        binding.butCompanyLogin.setOnClickListener {
            if (binding.etLoginEmail.text.isNotBlank() && binding.etLoginPassword.text.isNotBlank()) {
                Navigation.findNavController(view).navigate(R.id.navigateToCompanyHome)
            } else {
                Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_LONG).show()
            }
        }

    }

}