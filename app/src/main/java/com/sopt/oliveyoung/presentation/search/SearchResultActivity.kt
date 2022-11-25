package com.sopt.oliveyoung.presentation.search

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivitySearchResultBinding
import com.sopt.oliveyoung.presentation.CosmeticBrandAdapter
import com.sopt.oliveyoung.presentation.CosmeticProductAdapter
import com.sopt.oliveyoung.presentation.detail.DetailActivity
import com.sopt.oliveyoung.util.binding.BindingActivity

class SearchResultActivity :
    BindingActivity<ActivitySearchResultBinding>(R.layout.activity_search_result) {
    private val cosmeticBrandAdapter = CosmeticBrandAdapter(this)
    private val cosmeticProductAdapter = CosmeticProductAdapter(this, ::moveToProductDetail)
    private val viewModel: SearchViewModel by viewModels()
    private var searchKeyword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchKeyword = intent.getStringExtra("searchKeyword")
        viewModel.fetchSearchResultProduct(searchKeyword ?: return)
        initLayout()
        addObservers()
        addListeners()
    }

    private fun initLayout() {
        binding.rvCosmeticProduct.adapter = cosmeticProductAdapter
        binding.rvCosmeticBrand.adapter = cosmeticBrandAdapter
        binding.tvSearchbar.text = searchKeyword
    }

    private fun addListeners() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun addObservers() {
        viewModel.searchResultBrandData.observe(this) { brand ->
            if (brand != null)
                cosmeticBrandAdapter.setCosmeticBrandList(brand)
        }
        viewModel.searchResultProductData.observe(this) { product ->
            if (product != null)
                cosmeticProductAdapter.setCosmeticList(product)
        }
    }

    private fun moveToProductDetail() {
        startActivity(Intent(this, DetailActivity::class.java))
    }
}