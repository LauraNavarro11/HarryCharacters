package com.example.miharrypotter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HarryAdapter(private var listCharacter: List<CharactersResponse> = emptyList(), private val onItemSelected:(String)->Unit):
    RecyclerView.Adapter<HarryViewHolder>() {
    fun updateList(listCharacter: List<CharactersResponse>){
        this.listCharacter=listCharacter
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HarryViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return HarryViewHolder(layoutInflater.inflate(R.layout.item_characters,parent,false))    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

    override fun onBindViewHolder(holder: HarryViewHolder, position: Int) {
        val item=listCharacter[position]
        holder.bind(item,onItemSelected)
    }
}