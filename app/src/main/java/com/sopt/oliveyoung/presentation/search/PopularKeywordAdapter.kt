package com.sopt.oliveyoung.presentation.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.oliveyoung.databinding.ItemPopularSearchBinding

class PopularKeywordAdapter(context: Context) :
    RecyclerView.Adapter<PopularKeywordAdapter.PopularKeywordViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var popularKeywords: List<String> = emptyList()
    lateinit var popularSearchBinding: ItemPopularSearchBinding

    class PopularKeywordViewHolder(
        private val binding: ItemPopularSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: String) {
            binding.tvPopularSearch.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularKeywordViewHolder {
        popularSearchBinding = ItemPopularSearchBinding.inflate(inflater, parent, false)
        return PopularKeywordViewHolder(popularSearchBinding)
    }

    override fun onBindViewHolder(holder: PopularKeywordViewHolder, position: Int) {
        holder.onBind(popularKeywords[position])
    }

    override fun getItemCount() = popularKeywords.size

    fun setPopularSearchList(items: List<String>) {
        this.popularKeywords = items
        notifyItemRangeChanged(0, popularKeywords.size)
    }
}