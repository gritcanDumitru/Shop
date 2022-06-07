package com.example.shop.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R
import com.example.shop.databinding.ListItemProductBinding

private const val ITEM_PRODUCT: Int = 1

class ProductAdapter(
    private val favoriteListener: (ProductModel, Boolean) -> Unit,
) : ListAdapter<Item, ItemViewHolder>(ItemDiffCallback()) {

    enum class ScrollDirection {
        UP, DOWN
    }

    var scrollDirection = ScrollDirection.DOWN

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        if (viewType == ITEM_PRODUCT) {
            val binding = ListItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ItemViewHolder(binding, favoriteListener)
        } else throw IllegalArgumentException("No such type")
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        onBindViewHolder(holder, position, mutableListOf())
    }


    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is ProductModel) ITEM_PRODUCT
        else throw IllegalArgumentException("No such type")

    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
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
                is ProductPayloads.DescriptionChanged -> holder.setProductDescription(it.newDescription)
                is ProductPayloads.ImageChanged -> holder.setProductImage(it.newImage)
                is ProductPayloads.PriceChanged -> holder.setProductPrice(it.newPrice)
                is ProductPayloads.FavoriteStatusChanged -> holder.setProductFavoriteStatus(it.newFavoriteStatus)
            }
        }
        holder.setOnClickListeners(item)
    }
}

class ItemViewHolder(
    private val binding: ListItemProductBinding,
    private val favoriteListener: (ProductModel, Boolean) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item: ProductModel) {
        setProductImage(item.image)

    }

    fun setProductImage(image: String) {
        binding.productImage.setImageResource(R.drawable.ic_actions)
    }

    fun setProductPrice(price: Int) {
        binding.price.text = price.toString()
    }

    fun setProductDescription(description: String) {
        binding.details.text = description
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


class ItemDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.areItemsTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }

}