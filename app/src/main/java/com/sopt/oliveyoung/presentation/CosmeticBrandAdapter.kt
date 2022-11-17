package com.sopt.oliveyoung.presentation
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.oliveyoung.databinding.ItemCosmeticBrandBinding
import com.sopt.oliveyoung.databinding.ItemCosmeticProductBinding
import com.sopt.oliveyoung.domain.CosmeticBrandInfo

class CosmeticBrandAdapter(context: Context) : RecyclerView.Adapter<CosmeticBrandAdapter.RepoViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var cosmeticBrandList: List<CosmeticBrandInfo> = emptyList()
    lateinit var cosmeticBrandBinding: ItemCosmeticBrandBinding

    class RepoViewHolder(
        private val binding: ItemCosmeticBrandBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CosmeticBrandInfo) {
            binding.imgCosmeticBrand.load(data.imgBrand)
            binding.tvCosmeticBrand.text = data.brandName
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

    fun setCosmeticBrandList(repolist: List<CosmeticBrandInfo>) {
        this.cosmeticBrandList = repolist.toList()
        notifyItemRangeChanged(0, cosmeticBrandList.size)
    }
}