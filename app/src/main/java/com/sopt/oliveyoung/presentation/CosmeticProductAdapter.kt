package com.sopt.oliveyoung.presentation
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.oliveyoung.databinding.ItemCosmeticProductBinding
import com.sopt.oliveyoung.domain.CosmeticProductInfo

class CosmeticProductAdapter(context: Context) : RecyclerView.Adapter<CosmeticProductAdapter.RepoViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var cosmeticproductList: List<CosmeticProductInfo> = emptyList()
    lateinit var cosmeticProductBinding: ItemCosmeticProductBinding

    class RepoViewHolder(
        private val binding: ItemCosmeticProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CosmeticProductInfo) {
            binding.product = data
            binding.imgCosmetic.load(data.image)
            binding.tvBrand.text = data.brand
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        cosmeticProductBinding = ItemCosmeticProductBinding.inflate(inflater, parent, false)
        return RepoViewHolder(cosmeticProductBinding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(cosmeticproductList[position])
    }

    override fun getItemCount() = cosmeticproductList.size

    fun setCosmeticList(repolist: List<CosmeticProductInfo>) {
        this.cosmeticproductList = repolist.toList()
        notifyItemRangeChanged(0, cosmeticproductList.size)
    }
}