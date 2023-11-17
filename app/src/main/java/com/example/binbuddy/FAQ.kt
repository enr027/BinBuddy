package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.binbuddy.databinding.FragmentFAQBinding


class FAQ : Fragment(R.layout.fragment_f_a_q) {

    private lateinit var binding: FragmentFAQBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFAQBinding.bind(view)

        binding.userBackBar.inflateMenu(R.menu.backbar)

        binding.userBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.FAQBackToUserHome)
                    true
                }else -> false
            }
        }


    }
}