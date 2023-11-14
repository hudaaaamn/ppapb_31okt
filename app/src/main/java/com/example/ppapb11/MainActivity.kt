package com.example.ppapb11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ppapb11.databinding.ActivityMainBinding
import com.example.ppapb11.model.Users
import com.example.ppapb11.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var HeroList: ArrayList<ResultItem>
    private lateinit var RecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllUsers()
        HeroList = arrayListOf<ResultItem>()

        with(binding){
            val response = ApiClient.getInstance().getAllUsers()

            response.enqueue(object : Callback<com.example.ppapb11.Response>{
                override fun onResponse(
                    call: Call<com.example.ppapb11.Response>,
                    response: Response<com.example.ppapb11.Response>
                ) {
                    val heroResponse = response.body()
                    val heros = heroResponse?.result
                    if (heros != null){
                        for (i in heros){
                            val hero = ResultItem(i.image, i.id, i.title)
                            HeroList.add(hero)
                        }
                        RecyclerView = film
                        val adapter = HeroAdapter(HeroList)
                        RecyclerView.adapter = adapter

                    }
                }

                override fun onFailure(call: Call<com.example.ppapb11.Response>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Failed to retrieve data. Please check your internet connection.", Toast.LENGTH_SHORT).show()
                    // You can also log the error for debugging purposes
                    Log.e("MainActivity", "API call failed", t)
                }


            })

        }
    }
}