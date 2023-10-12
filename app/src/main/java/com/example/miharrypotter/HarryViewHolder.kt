package com.example.miharrypotter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.miharrypotter.databinding.ItemCharactersBinding
import com.squareup.picasso.Picasso

class HarryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding=ItemCharactersBinding.bind(view)
    fun bind(characterResponse:CharactersResponse,onItemSelected:(String)->Unit){
        binding.tvNameCharacter.text=characterResponse.name
        binding.tvHouseCharacter.text=characterResponse.house
        Glide.with(binding.tvHouseCharacter.context).load(characterResponse.image).into(binding.ivCharacters)
        binding.root.setOnClickListener { onItemSelected(characterResponse.id) }



    }
}