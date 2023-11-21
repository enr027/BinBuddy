package com.example.binbuddy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binbuddy.databinding.FragmentUserNotificationsBinding
import java.util.ArrayList


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


        val adaptorNotificationListUser = arrayListOf<NotificationsInfo>()
        getUserNotificationsData(adaptorNotificationListUser)


        binding.userNotificationsRecycler.layoutManager = LinearLayoutManager(context)
        binding.userNotificationsRecycler.adapter = NotAdaptor(adaptorNotificationListUser)
    }

    private fun getUserNotificationsData(list: ArrayList<NotificationsInfo>){
        val firstUserNotification = NotificationsInfo("Welcome to BinBuddy","You are in the notifications menu")
        list.add(firstUserNotification)

    }
}