package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCompanyNotificationsBinding


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
    }
}