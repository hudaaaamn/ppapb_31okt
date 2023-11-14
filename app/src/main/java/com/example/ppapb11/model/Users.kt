package com.example.ppapb11.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("result")
    val data: List<Data>

)
