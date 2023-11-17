package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentLoginBinding

class loginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.butCreateNewAcc.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.navigateToCreateAcc)
        }

        binding.butUserLogin.setOnClickListener {
            if (binding.etLoginEmail.text.isNotBlank() && binding.etLoginPassword.text.isNotBlank()){
                Navigation.findNavController(view).navigate(R.id.navigateToUserHome)
            }else{
                Toast.makeText(context,"Please fill out all fields", Toast.LENGTH_LONG).show()
            }
        }

        binding.butCompanyLogin.setOnClickListener {
            if (binding.etLoginEmail.text.isNotBlank() && binding.etLoginPassword.text.isNotBlank()) {
                Navigation.findNavController(view).navigate(R.id.navigateToCompanyHome)
            }else{
                Toast.makeText(context,"Please fill out all fields", Toast.LENGTH_LONG).show()
            }
        }

    }

}