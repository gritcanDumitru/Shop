package com.example.shop.presentation

data class ProductModel(
    val id: Int,
    val image: String,
    val title: String,
    val description: String,
    val price: Int,
    val isFavorite: Boolean,
) : Item {
    override fun areItemsTheSame(other: Any): Boolean {
        return other is ProductModel && id == other.id
    }

    override fun areContentsTheSame(other: Any): Boolean {
        return other is ProductModel
                && this.title == other.title
                && this.description == other.description
                && this.price == other.price
                && this.image == other.image

    }

    override fun getChangePayload(other: Any): Any? {
        return mutableListOf<Payloads>().apply {
            if (other is ProductModel){
                if (other.title != title){
                    add(ProductPayloads.TitleChanged(other.title))
                }
            if (other.description != description){
                    add(ProductPayloads.DescriptionChanged(other.description))
                }
            if (other.price != price){
                    add(ProductPayloads.PriceChanged(other.price))
                }
            if (other.image != image){
                    add(ProductPayloads.ImageChanged(other.image))
                }
            if (other.isFavorite != isFavorite){
                    add(ProductPayloads.FavoriteStatusChanged(other.isFavorite))
                }
            }
        }
    }
}