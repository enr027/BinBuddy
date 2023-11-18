package com.example.binbuddy

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerFAQAdaptor(var infos:List<FAQinfo>):RecyclerView.Adapter<RecyclerFAQAdaptor.FAQinfoViewHolder>(){

    inner class FAQinfoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val header:TextView = itemView.findViewById(R.id.txtFAQHeader)
        val desc:TextView = itemView.findViewById(R.id.expandedText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQinfoViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FAQinfoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}