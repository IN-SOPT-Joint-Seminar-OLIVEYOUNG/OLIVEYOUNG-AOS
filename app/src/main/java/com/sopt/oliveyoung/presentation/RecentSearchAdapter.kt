package com.sopt.oliveyoung.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.oliveyoung.databinding.ItemRecentSearchBinding
import com.sopt.oliveyoung.domain.RecentSearchInfo

class RecentSearchAdapter(context: Context) :
    RecyclerView.Adapter<RecentSearchAdapter.RepoViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var RecentSearchList: List<RecentSearchInfo> = emptyList()
    lateinit var RecentSearchBinding: ItemRecentSearchBinding

    class RepoViewHolder(
        private val binding: ItemRecentSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RecentSearchInfo) {
            binding.tvRecentSearch.text = data.tvRecentSearch
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        RecentSearchBinding = ItemRecentSearchBinding.inflate(inflater, parent, false)
        return RepoViewHolder(RecentSearchBinding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(RecentSearchList[position])
    }

    override fun getItemCount() = RecentSearchList.size

    fun setRecentSearchList(repolist: List<RecentSearchInfo>) {
        this.RecentSearchList = repolist.toList()
        notifyItemRangeChanged(0, RecentSearchList.size)
    }
}