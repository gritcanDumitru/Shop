package com.example.shop.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shop.domain.ProductsRepository
import com.example.shop.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

fun <T> createListedLiveData(): MutableLiveData<Result<List<T>>> {
    return MutableLiveData()
}

fun <T> MutableLiveData<T>.toLiveData(): LiveData<T> {
    return this
}

@HiltViewModel
class FeedViewModel @Inject constructor(private val repository: ProductsRepository) : ViewModel() {

    private val liveData = createListedLiveData<ProductModel>()
    val items = liveData.toLiveData()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = try {
                val feedEntity = repository.getProducts().map {
                    ProductModel(it.id, it.mainImage, it.name, it.details, it.price.toInt(), false)
                }
                Result.Success(feedEntity)
            } catch (e: Exception) {
                Result.Failed(e)
            }

            withContext(Dispatchers.Main) {
                liveData.value = result
            }
        }
    }
}