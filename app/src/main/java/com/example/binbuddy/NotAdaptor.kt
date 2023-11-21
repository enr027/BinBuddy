package com.example.binbuddy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class NotAdaptor(var Notis:ArrayList<NotificationsInfo>):RecyclerView.Adapter<NotAdaptor.NotificationViewHolder>(){

    inner class NotificationViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val header:TextView = itemView.findViewById(R.id.txtNotHeader)
        val descriptionOfNotification:TextView = itemView.findViewById(R.id.expandedText)
        val expandableText:ConstraintLayout = itemView.findViewById(R.id.expandableDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.notifications_banner,parent,false)
        return NotificationViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return Notis.size
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val currentItem = Notis[position]
        holder.header.text = currentItem.title
        holder.descriptionOfNotification.text = currentItem.description

        val isVisible:Boolean = currentItem.visibility

        holder.expandableText.visibility = if(isVisible) View.VISIBLE else View.GONE

        holder.header.setOnClickListener {
            currentItem.visibility = !currentItem.visibility
            notifyItemChanged(position)
        }
    }


}
