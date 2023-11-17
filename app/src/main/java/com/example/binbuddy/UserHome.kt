package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentUserHomeBinding


class UserHome : Fragment(R.layout.fragment_user_home) {

    private lateinit var binding: FragmentUserHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserHomeBinding.bind(view)

        binding.userBar.inflateMenu(R.menu.appbar)

        binding.userBar.setOnMenuItemClickListener{
            when(it.itemId) {
                R.id.menuFAQ -> {
                    Navigation.findNavController(view).navigate(R.id.navigateToFAQ)
                    true
                }else -> false
            }
        }

    }


}