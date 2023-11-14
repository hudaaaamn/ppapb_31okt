package com.example.ppapb11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ppapb11.databinding.ItemFilmBinding

class HeroAdapter(private val listHero: List<ResultItem>):
    RecyclerView.Adapter<HeroAdapter.ItemHeroViewHolder>() {

    inner class ItemHeroViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ResultItem) {
            with(binding) {
                idHero.text = data.id.toString()
                txtHeroName.text = data.title

                Glide.with(itemView.context).load(data.image).into(imgHero)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHeroViewHolder {
        val binding = ItemFilmBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemHeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHeroViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

}