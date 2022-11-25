package com.sopt.oliveyoung.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.oliveyoung.databinding.ItemCosmeticProductBinding
import com.sopt.oliveyoung.domain.CosmeticProductInfo

class CosmeticProductAdapter(context: Context) :
    RecyclerView.Adapter<CosmeticProductAdapter.itemViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var cosmeticproductList: List<CosmeticProductInfo> = emptyList()
    lateinit var cosmeticProductBinding: ItemCosmeticProductBinding

    class itemViewHolder(
        private val binding: ItemCosmeticProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CosmeticProductInfo) {
            binding.product = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        cosmeticProductBinding = ItemCosmeticProductBinding.inflate(inflater, parent, false)
        return itemViewHolder(cosmeticProductBinding)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.onBind(cosmeticproductList[position])
    }

    override fun getItemCount() = cosmeticproductList.size

    fun setCosmeticList(items: List<CosmeticProductInfo>) {
        this.cosmeticproductList = items.toList()
        notifyItemRangeChanged(0, cosmeticproductList.size)
    }
}