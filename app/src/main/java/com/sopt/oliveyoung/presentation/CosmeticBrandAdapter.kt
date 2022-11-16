package com.sopt.oliveyoung.presentation
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.oliveyoung.databinding.ItemCosmeticBrandBinding
import com.sopt.oliveyoung.databinding.ItemCosmeticProductBinding
import com.sopt.oliveyoung.domain.CosmeticBrandInfo

class CosmeticBrandAdapter(Item: List<CosmeticBrandInfo>, context: Context) : RecyclerView.Adapter<CosmeticBrandAdapter.RepoViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var cosmeticBrandList: List<CosmeticBrandInfo> = emptyList()
    lateinit var cosmeticBrandBinding: ItemCosmeticBrandBinding

    class RepoViewHolder( // 레포 뷰홀더
        private val binding: ItemCosmeticBrandBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CosmeticBrandInfo) {
            binding.imgCosmeticBrand.load(data.img_brand)
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

    fun setcosmeticList(repolist: List<CosmeticBrandInfo>) {
        this.cosmeticBrandList = repolist.toList() // 원본이 바뀌어도 문제가 생기지 않도록 "얇은 복사" 처리
        // notifyDataSetChanged() // 새로운 데이터셋을 인식시켜 이를 기반으로 다시 리사이클러 뷰를 그리도록 함
        notifyItemRangeChanged(0, cosmeticBrandList.size)
    }
}