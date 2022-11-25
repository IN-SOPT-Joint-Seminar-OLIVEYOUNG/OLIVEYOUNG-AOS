package com.sopt.oliveyoung.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.FragmentHomeBinding
import com.sopt.oliveyoung.presentation.search.SearchActivity
import com.sopt.oliveyoung.util.binding.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var recommendProductAdapter: CosmeticProductAdapter
    private lateinit var brandAdapter: CosmeticBrandAdapter
    private lateinit var brandProductAdapter: CosmeticProductAdapter

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recommendProductAdapter = CosmeticProductAdapter(requireContext())
        brandAdapter = CosmeticBrandAdapter(requireContext())
        brandProductAdapter = CosmeticProductAdapter(requireContext())

        initLayout()
        addListeners()
        addObservers()
    }

    private fun addListeners() {
        binding.ivSearch.setOnClickListener {
            startActivity(Intent(requireContext(), SearchActivity::class.java))
        }
    }

    private fun initLayout() {
        with(binding) {
            rvHomeMenu.adapter = HomeMenuAdapter(requireContext())
            rvSimilarProductList.adapter = recommendProductAdapter
            rvCosmeticBrand.adapter = brandAdapter
            rvBrandProductList.adapter = brandProductAdapter
        }
    }

    private fun addObservers() {
        viewModel.recommendProductList.observe(viewLifecycleOwner) { recommendProductList ->
            if (recommendProductList != null) recommendProductAdapter.setCosmeticList(recommendProductList)
        }
        viewModel.brandList.observe(viewLifecycleOwner) { brandList ->
            if (brandList != null) brandAdapter.setCosmeticBrandList(brandList)
        }
        viewModel.brandProductList.observe(viewLifecycleOwner) { brandProductList ->
            if (brandProductList != null) brandProductAdapter.setCosmeticList(brandProductList)
        }
    }
}