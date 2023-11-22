package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binbuddy.databinding.FragmentCompanyNotificationsBinding
import java.util.ArrayList


/**
 * Company Notifications sets up the company notifications fragment and the recycler view that will
 * hold the jobs the company has to do
 */

class CompanyNotifications : Fragment(R.layout.fragment_company_notifications) {
    private lateinit var binding: FragmentCompanyNotificationsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCompanyNotificationsBinding.bind(view)

        //inflate the menu back bar to be able to navigate back to company home
        binding.companyNotBackBar.inflateMenu(R.menu.backbar)

        //if back button is clicked navigate back to the company home fragment
        binding.companyNotBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.companyNotificationsBackToHome)
                    true
                }else -> false
            }
        }

        // set up the list of jobs to be created
        val adaptorNotificationListCompany = arrayListOf<NotificationsInfo>()
        getCompanyNotificationsData(adaptorNotificationListCompany)

        //set up the layout manager for the recycler view
        binding.companyNotificationsRecycler.layoutManager = LinearLayoutManager(context)
        //set up the adaptor for the recyler view
        binding.companyNotificationsRecycler.adapter = NotAdaptor(adaptorNotificationListCompany)
    }

    //private helper function that will initialize the list for the Jobs recycler view
    private fun getCompanyNotificationsData(list: ArrayList<NotificationsInfo>){
        val firstCompanyNotification = NotificationsInfo("BinBuddy Employee","This is where you will receive jobs")
        list.add(firstCompanyNotification)
    }
}