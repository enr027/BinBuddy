package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import com.example.binbuddy.databinding.CalenderBinding
import com.example.binbuddy.databinding.FragmentCalandarBinding

class Calendar : Fragment(R.layout.fragment_calandar) {
    private lateinit var binding: FragmentCalandarBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCalandarBinding.bind(view)
        binding.calenderBackBar.inflateMenu(R.menu.backbar)

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