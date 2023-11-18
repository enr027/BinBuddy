package com.example.binbuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.binbuddy.databinding.FragmentFAQBinding
import java.util.ArrayList


class FAQ : Fragment(R.layout.fragment_f_a_q) {

    private lateinit var binding: FragmentFAQBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFAQBinding.bind(view)

        binding.userBackBar.inflateMenu(R.menu.backbar)

        binding.userBackBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menuBack ->{
                    Navigation.findNavController(view).navigate(R.id.FAQBackToUserHome)
                    true
                }else -> false
            }
        }

        val AdaptorFAQList = arrayListOf<FAQinfo>()
        getFAQInfoData(AdaptorFAQList)


        binding.recycleFAQ.layoutManager = LinearLayoutManager(context)
        binding.recycleFAQ.adapter = RecyclerFAQAdaptor(AdaptorFAQList)

    }


    private fun getFAQInfoData(list:ArrayList<FAQinfo>){
        var headers = listOf<String>(getString(R.string.faqHeader1),getString(R.string.faqHeader2),
            getString(R.string.faqHeader3),getString(R.string.faqHeader4),getString(R.string.faqHeader5),
            getString(R.string.faqHeader6),getString(R.string.faqHeader7),getString(R.string.faqHeader8),
            getString(R.string.faqHeader9))

        var answers = listOf<String>(getString(R.string.faqAnswer1),getString(R.string.faqAnswer2),
            getString(R.string.faqAnswer3),getString(R.string.faqAnswer4),getString(R.string.faqAnswer5),
            getString(R.string.faqAnswer6),getString(R.string.faqAnswer7),getString(R.string.faqAnswer8),
            getString(R.string.faqAnswer9))

        for (i in headers.indices){
            val newFAQInfo = FAQinfo(headers[i],answers[i])
            list.add(newFAQInfo)
        }
    }
}