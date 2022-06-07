package com.example.shop.data

import com.example.shop.domain.ProductsResponse
import retrofit2.http.GET

interface ProductsService {

    @GET("products")
    suspend fun getProducts(): ProductsResponse

}