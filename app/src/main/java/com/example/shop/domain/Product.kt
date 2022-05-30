package com.example.shop.domain


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("category")
    val category: ReturnCategory,
    @SerializedName("colour")
    val colour: String,
    @SerializedName("details")
    val details: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main_image")
    val mainImage: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("size")
    val size: String
)
