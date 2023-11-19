package com.example.binbuddy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentUserNotificationsBinding


class UserNotifications : Fragment(R.layout.fragment_user_notifications) {
    private lateinit var binding: FragmentUserNotificationsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserNotificationsBinding.bind(view)

        binding.userNotificationsBackBar.inflateMenu(R.menu.backbar)

        binding.userNotificationsBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.userNotificationsBackToHome)
                    true
                }else -> false
            }
        }
    }
}