package com.sopt.oliveyoung.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.oliveyoung.databinding.ItemPopularSearchBinding
import com.sopt.oliveyoung.domain.PopularSearchInfo

class PopularSearchAdapter(context: Context) :
    RecyclerView.Adapter<PopularSearchAdapter.RepoViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var PopularSearchList: List<PopularSearchInfo> = emptyList()
    lateinit var PopularSearchBinding: ItemPopularSearchBinding

    class RepoViewHolder(
        private val binding: ItemPopularSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: PopularSearchInfo) {
            binding.tvPopularSearch.text = data.tvPopularSearch
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        PopularSearchBinding = ItemPopularSearchBinding.inflate(inflater, parent, false)
        return RepoViewHolder(PopularSearchBinding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(PopularSearchList[position])
    }

    override fun getItemCount() = PopularSearchList.size

    fun setPopularSearchList(repolist: List<PopularSearchInfo>) {
        this.PopularSearchList = repolist.toList()
        notifyItemRangeChanged(0, PopularSearchList.size)
    }
}