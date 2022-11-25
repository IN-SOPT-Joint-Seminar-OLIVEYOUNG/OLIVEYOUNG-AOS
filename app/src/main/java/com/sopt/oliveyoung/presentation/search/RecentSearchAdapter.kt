package com.sopt.oliveyoung.presentation.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.oliveyoung.databinding.ItemRecentSearchBinding

class RecentSearchAdapter(context: Context) :
    RecyclerView.Adapter<RecentSearchAdapter.recentSearchViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var recentSearchList: List<String> = emptyList()
    lateinit var recentSearchBinding: ItemRecentSearchBinding

    class recentSearchViewHolder(
        private val binding: ItemRecentSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: String) {
            binding.tvRecentSearch.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recentSearchViewHolder {
        recentSearchBinding = ItemRecentSearchBinding.inflate(inflater, parent, false)
        return recentSearchViewHolder(recentSearchBinding)
    }

    override fun onBindViewHolder(holder: recentSearchViewHolder, position: Int) {
        holder.onBind(recentSearchList[position])
    }

    override fun getItemCount() = recentSearchList.size

    fun setRecentSearchList(items: List<String>) {
        recentSearchList = items
        notifyItemRangeChanged(0, recentSearchList.size)
    }
}