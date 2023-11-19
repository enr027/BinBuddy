package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentUserAccountMenuBinding


class UserAccountMenu : Fragment(R.layout.fragment_user_account_menu) {

    private lateinit var binding: FragmentUserAccountMenuBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserAccountMenuBinding.bind(view)

        binding.accountMenuBackBar.inflateMenu(R.menu.backbar)

        binding.accountMenuBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.userAccountBackToUserHome)
                    true
                }else -> false
            }
        }

        binding.btnSignOutFromUser.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.userAccountBackToLogin)
        }
    }
}