package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binbuddy.databinding.FragmentCompanyNotificationsBinding
import java.util.ArrayList


class CompanyNotifications : Fragment(R.layout.fragment_company_notifications) {
    private lateinit var binding: FragmentCompanyNotificationsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCompanyNotificationsBinding.bind(view)

        binding.companyNotBackBar.inflateMenu(R.menu.backbar)

        binding.companyNotBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.companyNotificationsBackToHome)
                    true
                }else -> false
            }
        }

        val adaptorNotificationListCompany = arrayListOf<NotificationsInfo>()
        getCompanyNotificationsData(adaptorNotificationListCompany)


        binding.companyNotificationsRecycler.layoutManager = LinearLayoutManager(context)
        binding.companyNotificationsRecycler.adapter = NotAdaptor(adaptorNotificationListCompany)
    }

    private fun getCompanyNotificationsData(list: ArrayList<NotificationsInfo>){
        val firstCompanyNotification = NotificationsInfo("BinBuddy Employee","This is where you will receive jobs")
        list.add(firstCompanyNotification)
    }
}