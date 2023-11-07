package com.example.tugas_ricycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BuahAdapter(private val listBuah: ArrayList<Buah>):
    RecyclerView.Adapter<BuahAdapter.BuahViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class BuahViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        val gambarBuah: ImageView = itemView.findViewById(R.id.gambarBuah)
        val tvNamaBuah: TextView = itemView.findViewById(R.id.tvNamaBuah)
        val tvBioBuah: TextView = itemView.findViewById(R.id.tvBioBuah)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuahViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_buah, parent, false)

        return BuahViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return listBuah.size
    }

    override fun onBindViewHolder(holder: BuahViewHolder, position: Int) {
        val currentItem = listBuah[position]
        holder.gambarBuah.setImageResource(currentItem.gambarBuah)
        holder.tvNamaBuah.text = currentItem.namaBuah
        holder.tvBioBuah.text = currentItem.bioBuah

    }

}