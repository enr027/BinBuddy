package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            Navigation.findNavController(view).navigate(R.id.navigateBackToLogin)
        }

    }


}