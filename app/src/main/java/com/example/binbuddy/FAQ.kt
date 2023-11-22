package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.binbuddy.databinding.FragmentFAQBinding
import java.util.ArrayList

/**
 * FAQ fragment make the recycler view for the faq banners
 * The user will be able to click the faq's to expand them and see the full information
 */

class FAQ : Fragment(R.layout.fragment_f_a_q) {

    private lateinit var binding: FragmentFAQBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFAQBinding.bind(view)

        // inflate the back-bar menu to go back
        binding.userBackBar.inflateMenu(R.menu.backbar)

        // when the back icon is pressed navigate back to the user home
        binding.userBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.FAQBackToUserHome)
                    true
                }else -> false
            }
        }

        // create the list that list that will hold all the FAQ infos that will be shown
        val AdaptorFAQList = arrayListOf<FAQinfo>()
        // call methot get the FAQ's that will be shown
        getFAQInfoData(AdaptorFAQList)


        //initialize the Layout manager for the recycler view
        binding.recycleFAQ.layoutManager = LinearLayoutManager(context)
        //set up the adaptor to display the recycler view
        binding.recycleFAQ.adapter = RecyclerFAQAdaptor(AdaptorFAQList)

    }


    //private helper function that will get all the headers and answers that will be displayed in the FAQ
    // take in the list that will be used to populate the FAQ recycler view
    private fun getFAQInfoData(list:ArrayList<FAQinfo>){
        var headers = listOf<String>(getString(R.string.faqHeader1),getString(R.string.faqHeader2),
            getString(R.string.faqHeader3),getString(R.string.faqHeader4),getString(R.string.faqHeader5),
            getString(R.string.faqHeader6),getString(R.string.faqHeader7),getString(R.string.faqHeader8),
            getString(R.string.faqHeader9))

        var answers = listOf<String>(getString(R.string.faqAnswer1),getString(R.string.faqAnswer2),
            getString(R.string.faqAnswer3),getString(R.string.faqAnswer4),getString(R.string.faqAnswer5),
            getString(R.string.faqAnswer6),getString(R.string.faqAnswer7),getString(R.string.faqAnswer8),
            getString(R.string.faqAnswer9))

        // for every pair of headers and answers make a FAQInfo object so it can be shown in the recycler view
        // and add it to the list of FAQ's to be shown
        for (i in headers.indices){
            val newFAQInfo = FAQinfo(headers[i],answers[i])
            list.add(newFAQInfo)
        }
    }
}