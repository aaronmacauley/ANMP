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
        var name = Naruto[position].name
        var village = Naruto[position].village
        var rank = Naruto[position].rank
        var age =  Naruto[position].age
        var team = Naruto[position].team
        var status = Naruto[position].status

        var txtName = holder.itemView.findViewById<TextView>(R.id.txtNama)
        var txtVillage = holder.itemView.findViewById<TextView>(R.id.txtVillage)
        var txtAge = holder.itemView.findViewById<TextView>(R.id.txtAge)
        var txtTeam = holder.itemView.findViewById<TextView>(R.id.txtTeam)
        var txtRank = holder.itemView.findViewById<TextView>(R.id.txtRank)
        var txtStatus = holder.itemView.findViewById<TextView>(R.id.txtStatus)

        txtName.text= "$name"
        txtVillage.text= "$village"
        txtAge.text= "$age"
        txtTeam.text= "$team"
        txtRank.text= "$rank"
        txtStatus.text="$status"

    }
    fun updateNarutoList(newNaruto: ArrayList<Naruto>) {
        Naruto.clear()
        Naruto.addAll(newNaruto)
        notifyDataSetChanged()
    }
}