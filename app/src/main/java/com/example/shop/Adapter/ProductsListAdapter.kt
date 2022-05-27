import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.databinding.ListItemProductBinding

class ProductsListAdapter(
    private val favoriteListener: (String, Boolean) -> Unit
) : ListAdapter<ClipData.Item, ItemViewHolder>(ItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding, favoriteListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            if (payloads[0] == true) {

            }
        }
    }
}

class ItemViewHolder(
    private val binding: ListItemProductBinding,
    private val favoriteListener: (String, Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var item: ClipData.Item

    init {
        binding.favoriteButton.setOnClickListener {

        }
    }

}

class ItemDiffCallback : DiffUtil.ItemCallback<ClipData.Item>() {
    override fun areItemsTheSame(oldItem: ClipData.Item, newItem: ClipData.Item): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: ClipData.Item, newItem: ClipData.Item): Boolean {
        TODO("Not yet implemented")
    }

}