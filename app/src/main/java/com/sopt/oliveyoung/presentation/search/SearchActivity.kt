package com.sopt.oliveyoung.presentation.search

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivitySearchBinding
import com.sopt.oliveyoung.presentation.CosmeticProductAdapter
import com.sopt.oliveyoung.util.binding.BindingActivity

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

    private fun initLayout() {
        binding.rvRecentSearch.adapter = recentSearchAdapter
        binding.rvRecentProduct.adapter = recentProductAdapter
        binding.rvPopularSearch.adapter = PopularKeywordAdapter(this).apply {
            setPopularSearchList(listOf("립밤", "핸드크림", "틴트", "쿠션", "마스크팩", "향수", "수분크림", "선크림", "샴푸", "바디로션", "블러셔"))
        }
    }

    private fun addListeners() {
        binding.ivSearch.setOnClickListener {
            startActivity(Intent(this@SearchActivity, SearchResultActivity::class.java).apply {
                putExtra("searchKeyword", binding.etSearchbar.text.toString())
            })
        }
        binding.ivBack.setOnClickListener {
            finish()
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
}