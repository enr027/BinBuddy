package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCreateAccountBinding
import com.example.binbuddy.databinding.FragmentLoginBinding
import java.util.NavigableMap


class CreateAccountFragment : Fragment(R.layout.fragment_create_account) {

    private lateinit var binding: FragmentCreateAccountBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateAccountBinding.bind(view)

        binding.butNewAcc.setOnClickListener {
            if (binding.EtEnterFirstName.text.isNotBlank() && binding.EtEnterLastName.text.isNotBlank()
                && binding.EtEnterDirection.text.isNotBlank() && binding.EtNumberOfBins.text.isNotBlank()) {
                Navigation.findNavController(view).navigate(R.id.navigateBackToLogin)
            }else{
                Toast.makeText(context,"Please fill out all fields",Toast.LENGTH_LONG).show()
            }
        }

    }


}