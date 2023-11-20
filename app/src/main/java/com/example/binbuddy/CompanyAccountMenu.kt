package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCompanyAccountMenuBinding
import com.example.binbuddy.databinding.FragmentCreateAccountBinding

class CompanyAccountMenu : Fragment(R.layout.fragment_company_account_menu) {
    private lateinit var binding: FragmentCompanyAccountMenuBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding  = FragmentCompanyAccountMenuBinding.bind(view)

        binding.cAccountBackBar.inflateMenu(R.menu.backbar)

        binding.cAccountBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.companyAccountMenuBackToHome)
                    true
                }else -> false
            }
        }

        binding.btnSignOutCompany.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.companyAccountMenuBackToLogin)
        }
    }
}