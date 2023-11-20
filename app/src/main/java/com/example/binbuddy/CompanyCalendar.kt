package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCompanyCalendarBinding


class CompanyCalendar : Fragment(R.layout.fragment_company_calendar) {
    private lateinit var binding: FragmentCompanyCalendarBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCompanyCalendarBinding.bind(view)

        binding.companyCalendarBack.inflateMenu(R.menu.backbar)


        binding.companyCalendarBack.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.companyCalendarBackToHome)
                    true
                }else -> false
            }
        }
    }
}