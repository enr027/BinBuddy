package com.example.binbuddy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerFAQAdaptor(var infos:ArrayList<FAQinfo>):RecyclerView.Adapter<RecyclerFAQAdaptor.FAQinfoViewHolder>(){

    inner class FAQinfoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val header:TextView = itemView.findViewById(R.id.txtFAQHeader)
        val descriptionOfFAQ:TextView = itemView.findViewById(R.id.expandedText)
        val expandableText:ConstraintLayout = itemView.findViewById(R.id.expandableDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQinfoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.faq_banner,parent,false)
        return FAQinfoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return infos.size
    }

    override fun onBindViewHolder(holder: FAQinfoViewHolder, position: Int) {
        val currentItem = infos[position]
        holder.header.text = currentItem.title
        holder.descriptionOfFAQ.text = currentItem.description

        val isVisible:Boolean = currentItem.visibility

        holder.expandableText.visibility = if(isVisible) View.VISIBLE else View.GONE

        holder.header.setOnClickListener {
            currentItem.visibility = !currentItem.visibility
            notifyItemChanged(position)
        }
    }


}