package com.example.binbuddy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * Faq Recycler view adaptor
 */
class RecyclerFAQAdaptor(var infos:ArrayList<FAQinfo>):RecyclerView.Adapter<RecyclerFAQAdaptor.FAQinfoViewHolder>(){

    // holder to hold all instance of the recycler view
    inner class FAQinfoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val header:TextView = itemView.findViewById(R.id.txtFAQHeader)
        val descriptionOfFAQ:TextView = itemView.findViewById(R.id.expandedText)
        val expandableText:ConstraintLayout = itemView.findViewById(R.id.expandableDescription)
    }
    //create view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQinfoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.faq_banner,parent,false)
        return FAQinfoViewHolder(itemView)
    }

    //returns the size of the recycler view
    override fun getItemCount(): Int {
        return infos.size
    }

    // on bind created new Notification info's to be displayed
    override fun onBindViewHolder(holder: FAQinfoViewHolder, position: Int) {
        val currentItem = infos[position]
        holder.header.text = currentItem.title
        holder.descriptionOfFAQ.text = currentItem.description

        // if clicked show the contents inside
        val isVisible:Boolean = currentItem.visibility

        holder.expandableText.visibility = if(isVisible) View.VISIBLE else View.GONE

        holder.header.setOnClickListener {
            currentItem.visibility = !currentItem.visibility
            notifyItemChanged(position)
        }
    }


}