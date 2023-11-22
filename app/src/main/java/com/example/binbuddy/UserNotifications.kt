package com.example.binbuddy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binbuddy.databinding.FragmentUserNotificationsBinding
import java.util.ArrayList

/**
 * Sets up the UserNotifications fragments to show user notifications
 */

class UserNotifications : Fragment(R.layout.fragment_user_notifications) {
    private lateinit var binding: FragmentUserNotificationsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserNotificationsBinding.bind(view)

        //inflate the back menu bar to return to the user home
        binding.userNotificationsBackBar.inflateMenu(R.menu.backbar)

        // if back button is clicked return back to the use home
        binding.userNotificationsBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.userNotificationsBackToHome)
                    true
                }else -> false
            }
        }

        // set up the array list to be used for the recycler view
        val adaptorNotificationListUser = arrayListOf<NotificationsInfo>()
        getUserNotificationsData(adaptorNotificationListUser)

        //initialize the layout manager fot recycler view
        binding.userNotificationsRecycler.layoutManager = LinearLayoutManager(context)
        //initialize the adaptor for notifications
        binding.userNotificationsRecycler.adapter = NotAdaptor(adaptorNotificationListUser)
    }

    // helper private method to initialize the list to be used for the recycler view
    private fun getUserNotificationsData(list: ArrayList<NotificationsInfo>){
        val firstUserNotification = NotificationsInfo("Welcome to BinBuddy","You are in the notifications menu")
        list.add(firstUserNotification)

    }
}