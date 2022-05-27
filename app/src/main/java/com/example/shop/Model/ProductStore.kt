package com.example.shop.Model

import android.content.Context

object ProductStore {

    private const val TAG = "ProductStore"

    private lateinit var products: List<Products>
    private lateinit var category: List<ReturnCategory>

    fun loadProducts(context: Context){}

    fun getProduct() = products

    fun getProductById(id: Int) = products.firstOrNull { it.id == id }

    fun getCategoryById(id: Int) = category.firstOrNull { it.id == id }
}