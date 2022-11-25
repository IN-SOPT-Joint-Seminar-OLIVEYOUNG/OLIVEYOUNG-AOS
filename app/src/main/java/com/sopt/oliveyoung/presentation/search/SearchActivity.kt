package com.sopt.oliveyoung.presentation.search

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivitySearchBinding
import com.sopt.oliveyoung.presentation.CosmeticProductAdapter
import com.sopt.oliveyoung.util.binding.BindingActivity
import timber.log.Timber

class SearchActivity : BindingActivity<ActivitySearchBinding>(R.layout.activity_search) {
    private val recentSearchAdapter = RecentSearchAdapter(this)
    private val recentProductAdapter = CosmeticProductAdapter(this)
    private val viewModel: SearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
        addObservers()
        addListeners()
    }

    private fun addListeners() {
        binding.ivSearch.setOnClickListener {
            startActivity(Intent(this@SearchActivity, SearchResultActivity::class.java).apply {
                putExtra("searchKeyword", binding.etSearchbar.text.toString())
                Timber.d(binding.etSearchbar.text.toString())
            })
        }
    }

    private fun addObservers() {
        viewModel.searchData.observe(this) { recentSearch ->
            if (recentSearch != null)
                recentSearchAdapter.setRecentSearchList(recentSearch!!.recentWords)
        }
        viewModel.searchProductData.observe(this) { product ->
            if (product != null)
                recentProductAdapter.setCosmeticList(product)
        }
    }

    private fun initLayout() {
        binding.rvRecentSearch.adapter = recentSearchAdapter
        binding.rvRecentProduct.adapter = recentProductAdapter
    }
}