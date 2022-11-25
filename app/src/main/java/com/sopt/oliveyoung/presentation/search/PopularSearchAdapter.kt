package com.sopt.oliveyoung.presentation.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.oliveyoung.databinding.ItemPopularSearchBinding
import com.sopt.oliveyoung.domain.PopularSearchInfo

class PopularSearchAdapter(context: Context) :
    RecyclerView.Adapter<PopularSearchAdapter.RepoViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var popularSearchList: List<PopularSearchInfo> = emptyList()
    lateinit var popularSearchBinding: ItemPopularSearchBinding

    class RepoViewHolder(
        private val binding: ItemPopularSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: PopularSearchInfo) {
            binding.tvPopularSearch.text = data.tvPopularSearch
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        popularSearchBinding = ItemPopularSearchBinding.inflate(inflater, parent, false)
        return RepoViewHolder(popularSearchBinding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(popularSearchList[position])
    }

    override fun getItemCount() = popularSearchList.size

    fun setPopularSearchList(repolist: List<PopularSearchInfo>) {
        this.popularSearchList = repolist.toList()
        notifyItemRangeChanged(0, popularSearchList.size)
    }
}