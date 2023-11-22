package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCompanyAccountMenuBinding
import com.example.binbuddy.databinding.FragmentCreateAccountBinding

/**
 * CompanyAccountMenu sets up the Company account menu
 */
class CompanyAccountMenu : Fragment(R.layout.fragment_company_account_menu) {
    private lateinit var binding: FragmentCompanyAccountMenuBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding  = FragmentCompanyAccountMenuBinding.bind(view)

        //inflate the back bar menu to be able to navigate back to company home
        binding.cAccountBackBar.inflateMenu(R.menu.backbar)

        // listen to when the back bar button is clicked to navigate back to the company home
        binding.cAccountBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.companyAccountMenuBackToHome)
                    true
                }else -> false
            }
        }

        // listen to when the sign out is click to go back to login fragment
        binding.btnSignOutCompany.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.companyAccountMenuBackToLogin)
        }
    }
}