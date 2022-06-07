package com.example.shop.di

import com.example.shop.data.RetrofitMain
import com.example.shop.domain.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object RepositoryModule {
    @Provides
    @Singleton
    fun provideProductsRepository() = ProductsRepository(RetrofitMain.productServiceImpl)

}