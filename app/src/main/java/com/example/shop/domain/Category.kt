package com.example.shop.domain


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("icon")
    val icon: String,
    @SerializedName("name")
    val name: String
)