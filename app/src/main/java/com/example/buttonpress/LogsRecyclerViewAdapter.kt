package com.example.buttonpress

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.buttonpress.data.ButtonPress
import com.example.buttonpress.data.getDateTime

class LogsRecyclerViewAdapter(
    private var itemsList: List<ButtonPress>
) : RecyclerView.Adapter<LogsRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvLog: TextView = view.findViewById(R.id.tvLog)
        var tvDateTime: TextView = view.findViewById(R.id.tvDateTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.tvLog.text = item.buttonName
        holder.tvDateTime.text = item.getDateTime()
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}