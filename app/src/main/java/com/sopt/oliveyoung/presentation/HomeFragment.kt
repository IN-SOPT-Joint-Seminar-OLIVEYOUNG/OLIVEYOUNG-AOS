package com.sopt.oliveyoung.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.FragmentHomeBinding
import com.sopt.oliveyoung.util.binding.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var adapter: CosmeticProductAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CosmeticProductAdapter(requireContext())
        initLayout()
        addObservers()
    }

    private fun initLayout() {
        binding.rvHomeMenu.adapter = HomeMenuAdapter(requireContext())
        binding.rvSimilarProductList.adapter = adapter
    }

    private fun addObservers() {
        viewModel.recommendProductList.observe(viewLifecycleOwner) { recommendProductList ->
            if (recommendProductList != null) adapter.setCosmeticList(recommendProductList)

        }
    }
}