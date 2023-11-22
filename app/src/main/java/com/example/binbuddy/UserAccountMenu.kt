package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentUserAccountMenuBinding

/**
 * UserAccountMenu sets up the up the Account menu fragment for the user
 */
class UserAccountMenu : Fragment(R.layout.fragment_user_account_menu) {

    private lateinit var binding: FragmentUserAccountMenuBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserAccountMenuBinding.bind(view)

        // inflate the back menu to be able to return back to user home
        binding.accountMenuBackBar.inflateMenu(R.menu.backbar)

        // if back button is clicked return back to user home
        binding.accountMenuBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.userAccountBackToUserHome)
                    true
                }else -> false
            }
        }

        // if sign out button is clicked exit to the login fragment
        binding.btnSignOutFromUser.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.userAccountBackToLogin)
        }
    }
}