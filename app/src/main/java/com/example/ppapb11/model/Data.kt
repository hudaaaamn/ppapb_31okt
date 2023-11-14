package com.example.ppapb11.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val heroName: String,
    @SerializedName("image")
    val heroImage: String
)
