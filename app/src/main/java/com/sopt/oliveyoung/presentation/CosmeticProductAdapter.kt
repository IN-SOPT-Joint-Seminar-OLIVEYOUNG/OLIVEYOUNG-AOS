package com.sopt.oliveyoung.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.oliveyoung.databinding.ItemCosmeticProductBinding
import com.sopt.oliveyoung.domain.CosmeticProductInfo

class CosmeticProductAdapter(
    context: Context,
    private val onItemClickListener: (() -> Unit)? = null,
) :
    RecyclerView.Adapter<CosmeticProductAdapter.ProductViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var cosmeticProductList: List<CosmeticProductInfo> = emptyList()
    private lateinit var cosmeticProductBinding: ItemCosmeticProductBinding

    class ProductViewHolder(
        private val binding: ItemCosmeticProductBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CosmeticProductInfo, onItemClickListener: (() -> Unit)?) {
            binding.product = data
            onItemClickListener?.let { listener ->
                binding.root.setOnClickListener { listener() }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        cosmeticProductBinding = ItemCosmeticProductBinding.inflate(inflater, parent, false)
        return ProductViewHolder(cosmeticProductBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(cosmeticProductList[position], onItemClickListener)
    }

    override fun getItemCount() = cosmeticProductList.size

    fun setCosmeticList(items: List<CosmeticProductInfo>) {
        this.cosmeticProductList = items.toList()
        notifyItemRangeChanged(0, cosmeticProductList.size)
    }
}