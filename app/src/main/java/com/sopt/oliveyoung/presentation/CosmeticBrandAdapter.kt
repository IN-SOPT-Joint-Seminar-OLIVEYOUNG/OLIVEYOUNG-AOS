package com.sopt.oliveyoung.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.oliveyoung.databinding.ItemCosmeticBrandBinding
import com.sopt.oliveyoung.domain.CosmeticBrandInfo

class CosmeticBrandAdapter(context: Context) :
    RecyclerView.Adapter<CosmeticBrandAdapter.RepoViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var cosmeticBrandList: List<CosmeticBrandInfo> = emptyList()
    private lateinit var cosmeticBrandBinding: ItemCosmeticBrandBinding

    class RepoViewHolder(
        private val binding: ItemCosmeticBrandBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CosmeticBrandInfo) {
            binding.brand = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        cosmeticBrandBinding = ItemCosmeticBrandBinding.inflate(inflater, parent, false)
        return RepoViewHolder(cosmeticBrandBinding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(cosmeticBrandList[position])
    }

    override fun getItemCount() = cosmeticBrandList.size

    fun setCosmeticBrandList(items: List<CosmeticBrandInfo>) {
        this.cosmeticBrandList = items
        notifyItemRangeChanged(0, cosmeticBrandList.size)
    }
}