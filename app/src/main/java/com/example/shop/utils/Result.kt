package com.example.shop.utils

sealed class Result<T> {
    data class Success<T>(val data:T): Result<T>()
    data class Failed<T>(val exception: Exception): Result<T>()
}