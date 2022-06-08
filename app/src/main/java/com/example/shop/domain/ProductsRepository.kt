package com.example.shop.domain

import com.example.shop.data.ProductsService

class ProductsRepository(private val productsService: ProductsService) {


    suspend fun getProducts(): List<Product> {

        val response = productsService.getProducts()
        return response.results
    }

}