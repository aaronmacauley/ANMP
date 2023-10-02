package com.example.anmp_week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anmp_week4.R
import com.example.anmp_week4.model.Naruto

import org.w3c.dom.Text

class NarutoListAdapter(val Naruto:ArrayList<Naruto>):RecyclerView.Adapter<NarutoListAdapter.NarutoViewHolder>() {
    class NarutoViewHolder(v:View):RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NarutoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.naruto_list_item, parent, false)
        return NarutoViewHolder(view)
    }

    override fun getItemCount(): Int {
    return  Naruto.size
    }

    override fun onBindViewHolder(holder: NarutoViewHolder, position: Int) {
        var txtResult = holder.itemView.findViewById<TextView>(R.id.txtResult)
        var name = Naruto[position].name
        var village = Naruto[position].village
        var rank = Naruto[position].rank
        txtResult.text= "$name-$village-$rank"
    }
    fun updateNarutoList(newNaruto: ArrayList<Naruto>) {
        Naruto.clear()
        Naruto.addAll(newNaruto)
        notifyDataSetChanged()
    }
}