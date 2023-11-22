package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCompanyCalendarBinding

/**
 * Company Calendar sets up the Calender for the Company
 */

class CompanyCalendar : Fragment(R.layout.fragment_company_calendar) {
    private lateinit var binding: FragmentCompanyCalendarBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCompanyCalendarBinding.bind(view)

        // inflate back menu to be able to navigate back to the Company home
        binding.companyCalendarBack.inflateMenu(R.menu.backbar)


        // listen to when the back button is clicked to navigate back to the company home
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