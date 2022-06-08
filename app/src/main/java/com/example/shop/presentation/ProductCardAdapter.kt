package com.example.shop.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R
import com.example.shop.databinding.ListItemCardProductBinding

private const val ITEM_PRODUCT: Int = 1

class ProductCardAdapter(
        private val favoriteListener: (ProductModel, Boolean) -> Unit,
    ) : ListAdapter<Item, ItemViewHolderCard>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolderCard {
        if (viewType == ITEM_PRODUCT) {
            val binding = ListItemCardProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ItemViewHolderCard(binding, favoriteListener)
        } else throw IllegalArgumentException("No such type")    }

    override fun onBindViewHolder(holder: ItemViewHolderCard, position: Int) {
        onBindViewHolder(holder, position, mutableListOf())
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is ProductModel) ITEM_PRODUCT
        else throw IllegalArgumentException("No such type")

    }

    override fun onBindViewHolder(
        holder: ItemViewHolderCard,
        position: Int,
        payloads: MutableList<Any>,
    ) {
        //Create mapper Item.toUIModel(holder) || if ViewHolder is ...
        val item = getItem(position) as ProductModel? ?: return

        if (payloads.isEmpty()) {
            holder.bind(item)
        } else payloads.forEach {
            when (it) {
                is ProductPayloads.TitleChanged -> holder.setProductTitle(it.newTitle)
                is ProductPayloads.ImageChanged -> holder.setProductImage(it.newImage)
                is ProductPayloads.FavoriteStatusChanged -> holder.setProductFavoriteStatus(it.newFavoriteStatus)
            }
        }
        holder.setOnClickListeners(item)
    }

}
class ItemViewHolderCard(
    private val binding: ListItemCardProductBinding,
    private val favoriteListener: (ProductModel, Boolean) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ProductModel) {
        setProductImage(item.image)
    }

    fun setProductImage(image: String) {
        binding.productImage.setImageResource(R.drawable.ic_actions)
    }

    fun setProductTitle(title: String) {
        binding.productName.text = title
    }

    fun setProductFavoriteStatus(isFavorite: Boolean) {
        binding.favoriteButton.isSelected = isFavorite
    }

    fun setOnClickListeners(item: ProductModel) {
        binding.favoriteButton.setOnClickListener {
            favoriteListener(item, !it.isSelected)
        }
    }
}
