package com.example.ppapb11.network

import com.example.ppapb11.Response
import com.example.ppapb11.ResultItem
import com.example.ppapb11.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("data.php")
    fun getAllUsers(): Call<Response>
}