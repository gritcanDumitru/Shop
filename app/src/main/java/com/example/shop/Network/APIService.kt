package com.example.shop.Network

import com.example.shop.Model.Products
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("products")
    fun getProductsList(): Call<MutableList<Products>>
}