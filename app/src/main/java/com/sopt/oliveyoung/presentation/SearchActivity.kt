package com.sopt.oliveyoung.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivitySearchBinding
import com.sopt.oliveyoung.domain.CosmeticProductInfo
import com.sopt.oliveyoung.domain.PopularSearchInfo
import com.sopt.oliveyoung.util.binding.BindingActivity

class SearchActivity : BindingActivity<ActivitySearchBinding>(R.layout.activity_search) {
    private val RecentSearchAdapter = RecentSearchAdapter(this)
    private val RecentProductAdapter = CosmeticProductAdapter(this)
    private val viewModel: SearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
        addObservers()
    }

    private fun addObservers() {
        viewModel.SearchData.observe(this) { recentSearch ->
            if (recentSearch != null)
                RecentSearchAdapter.setRecentSearchList(recentSearch!!.recentWords)
        }
    }

    private fun initLayout() {
        binding.rvPopularSearch.adapter = PopularSearchAdapter(
            this
        ).apply {
            setPopularSearchList(
                listOf(
                    PopularSearchInfo("립밤"),
                    PopularSearchInfo("핸드크림"),
                    PopularSearchInfo("틴트"),
                    PopularSearchInfo("쿠션"),
                    PopularSearchInfo("마스크팩"),
                    PopularSearchInfo("향수"),
                    PopularSearchInfo("립밤"),
                    PopularSearchInfo("핸드크림"),
                    PopularSearchInfo("틴트"),
                    PopularSearchInfo("쿠션"),
                    PopularSearchInfo("마스크팩")
                )
            )
        }

        binding.rvRecentSearch.adapter = RecentSearchAdapter
//        ).apply {
//            setRecentSearchList(
//                listOf(
//                    RecentSearchInfo("립밤"),
//                    RecentSearchInfo("핸드크림"),
//                    RecentSearchInfo("틴트"),
//                    RecentSearchInfo("쿠션"),
//                    RecentSearchInfo("마스크팩"),
//                    RecentSearchInfo("향수"),
//                    RecentSearchInfo("스킨케어")
//
//                )
//            )
//        }

        binding.rvRecentProduct.adapter = CosmeticProductAdapter(this)
            .apply {
                setCosmeticList(
                    listOf(
                        CosmeticProductInfo(
                            "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
                            "에스트라",
                            "아토베리어365 크림 80ml 더블 기획",
                            30900,
                            30
                        ),
                        CosmeticProductInfo(
                            "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
                            "에스트라",
                            "아토베리어365 크림 80ml 더블 기획",
                            30900,
                            30
                        ),
                        CosmeticProductInfo(
                            "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
                            "에스트라",
                            "아토베리어365 크림 80ml 더블 기획",
                            30900,
                            30
                        )

                    )
                )
            }

    }
}