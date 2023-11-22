package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.FragmentCalandarBinding

/**
 * Calendar sets up the calendar fragment
 */
class Calendar : Fragment(R.layout.fragment_calandar) {
    private lateinit var binding: FragmentCalandarBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCalandarBinding.bind(view)
        //inflates the menu back bar to navigate back to the user home menu
        binding.calenderBackBar.inflateMenu(R.menu.backbar)

        // listen to when the back bar is clicked to Navigate back to the user home
        binding.calenderBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.fromUserCalendarToHome)
                    true
                }else -> false
            }
        }
    }


}