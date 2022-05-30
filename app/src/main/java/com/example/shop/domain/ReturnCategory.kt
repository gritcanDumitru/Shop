package com.example.shop.domain


import com.google.gson.annotations.SerializedName

data class ReturnCategory(
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)