package com.sopt.oliveyoung.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.oliveyoung.databinding.ItemHomeMenuBinding
import com.sopt.oliveyoung.presentation.types.HomeMenuType

class HomeMenuAdapter(val context: Context) :
    RecyclerView.Adapter<HomeMenuAdapter.HomeMenuViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var homeMenuList: Array<HomeMenuType> = HomeMenuType.values()

    init {
        notifyDataSetChanged()
    }

    class HomeMenuViewHolder(
        private val binding: ItemHomeMenuBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeMenuType, context: Context) {
            binding.rvHomeMenuTitle.text = context.getString(data.strRes)
            binding.ivHomeMenuImage.load(data.imgRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMenuViewHolder {
        val binding = ItemHomeMenuBinding.inflate(inflater, parent, false)
        return HomeMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeMenuViewHolder, position: Int) {
        holder.onBind(homeMenuList[position], context)
    }

    override fun getItemCount() = homeMenuList.size
}
