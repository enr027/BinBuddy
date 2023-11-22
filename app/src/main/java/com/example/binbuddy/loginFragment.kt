package com.example.binbuddy

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

/**
 * Login Fragment displays the login page where the user can either enter their account or
 * navigate to the create account screen
 */
class loginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth //  authorization database to check users



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        firebaseAuth = FirebaseAuth.getInstance() // get instance of authorization database

        // click listener to for when user button is pressed
        binding.butUserLogin.setOnClickListener {
            //when user button is pressed get the email and password string
            val email = binding.etLoginEmail.text.toString()
            val password = binding.etLoginPassword.text.toString()

            //Check if fields are filled out
            if (email.isNotEmpty() && password.isNotEmpty()) {
                //Sign in with firebase auth using email and password
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        //Nav to userhome if successful
                        Navigation.findNavController(view).navigate(R.id.navigateToUserHome)
                    } else
                    {
                        //if there exists no account notice the user to make a create account
                        Toast.makeText(context, "Please make a new account", Toast.LENGTH_LONG).show()
                    }
                    }
                } else Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_LONG)
                    .show() // if one or both fields are empty notice user to enter all fields
            }

        // if create new button is pressed navigate to the create account fragment
        binding.butCreateNewAcc.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.navigateToCreateAcc)
        }

        // check for when company login is pressed
        binding.butCompanyLogin.setOnClickListener {
            //when company login is pressed get email and password
            val email = binding.etLoginEmail.text.toString()
            val password = binding.etLoginPassword.text.toString()

            if (binding.etLoginEmail.text.isNotBlank() && binding.etLoginPassword.text.isNotBlank()) {
                // only email containing binbuddy and having a password adminbuddy can enter though company login
                if(email.contains("binbuddy") && password == "adminbuddy") {
                    //sign in using firebase
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            //Nav to company home if successful
                            Navigation.findNavController(view).navigate(R.id.navigateToCompanyHome)
                        }
                    }
                }
            } else {
                //if empty advise user to fill out all fields
                Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_LONG).show()
            }
        }

    }

}