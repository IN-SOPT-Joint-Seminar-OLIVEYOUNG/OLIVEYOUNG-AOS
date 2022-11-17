package com.sopt.oliveyoung.presentation
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.oliveyoung.databinding.ItemRecentProductBinding
import com.sopt.oliveyoung.domain.RecentProductInfo

class RecentProductAdapter(context: Context) : RecyclerView.Adapter<RecentProductAdapter.RepoViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var RecentproductList: List<RecentProductInfo> = emptyList()
    lateinit var RecentProductBinding: ItemRecentProductBinding

    class RepoViewHolder(
        private val binding: ItemRecentProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RecentProductInfo) {
            binding.product = data
            binding.imgCosmetic.load(data.image)
            binding.tvBrand.text = data.brand
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        RecentProductBinding = ItemRecentProductBinding.inflate(inflater, parent, false)
        return RepoViewHolder(RecentProductBinding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(RecentproductList[position])
    }

    override fun getItemCount() = RecentproductList.size

    fun setRecentProductList(repolist: List<RecentProductInfo>) {
        this.RecentproductList = repolist.toList()
        notifyItemRangeChanged(0, RecentproductList.size)
    }
}