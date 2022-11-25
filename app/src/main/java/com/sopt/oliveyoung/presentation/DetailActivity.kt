package com.sopt.oliveyoung.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivityDetailBinding
import com.sopt.oliveyoung.util.binding.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val viewModel: ProductDetailViewModel by viewModels()
    private val similarProductAdapter = CosmeticProductAdapter(this)
    private val recommendProductAdapter = CosmeticProductAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initLayout()
        addListeners()
        addObservers()
    }

    private fun initLayout() {
        binding.viewHashtag.setHashtag(listOf("립밤", "핸드크림", "틴트", "쿠션", "마스크팩"))
        binding.rvSimilarProductList.adapter = similarProductAdapter
        binding.rvRecommendProductList.adapter = recommendProductAdapter
    }

    private fun addListeners() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun addObservers() {
        viewModel.similarProduct.observe(this) { similars ->
            similarProductAdapter.setCosmeticList(similars ?: return@observe)
        }

        viewModel.recommendProduct.observe(this) { recommends ->
            recommendProductAdapter.setCosmeticList(recommends ?: return@observe)
        }
    }
}