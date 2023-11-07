package com.example.tugas_ricycleview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas_ricycleview.databinding.ActivityBuahDetailBinding


class BuahDetail : AppCompatActivity() {

    private lateinit var binding: ActivityBuahDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuahDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val namaBuah =bundle!!.getString("nama buah")
        val bioBuah =bundle!!.getString("bio buah")
        val gambarBuah = bundle!!.getInt("gambar buah")

        with(binding) {
            tvNamaBuah.text = namaBuah
            tvBioBuah.text = bioBuah
            ivBuah.setImageResource(gambarBuah)

            btnBack.setOnClickListener{
                var intent = Intent(this@BuahDetail, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}