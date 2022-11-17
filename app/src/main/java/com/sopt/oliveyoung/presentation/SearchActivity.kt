package com.sopt.oliveyoung.presentation

import android.os.Bundle
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivitySearchBinding
import com.sopt.oliveyoung.domain.CosmeticProductInfo
import com.sopt.oliveyoung.domain.PopularSearchInfo
import com.sopt.oliveyoung.domain.RecentProductInfo
import com.sopt.oliveyoung.domain.RecentSearchInfo
import com.sopt.oliveyoung.util.binding.BindingActivity

class SearchActivity : BindingActivity<ActivitySearchBinding>(R.layout.activity_search) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        binding.rvPopularSearch.adapter = PopularSearchAdapter(
            this
        ).apply {
            setPopularSearchList(
                listOf(
                    PopularSearchInfo("립밤"),
                    PopularSearchInfo("크림"),
                    PopularSearchInfo("틴트"),
                    PopularSearchInfo("쿠션"),
                    PopularSearchInfo("팩트"),
                    PopularSearchInfo("향수"),
                    PopularSearchInfo("립밤"),
                    PopularSearchInfo("크림"),
                    PopularSearchInfo("틴트"),
                    PopularSearchInfo("쿠션"),
                    PopularSearchInfo("팩트"),
                    PopularSearchInfo("향수"),
                )
            )
        }

        binding.rvRecentSearch.adapter = RecentSearchAdapter(
            this
        ).apply {
            setRecentSearchList(
                listOf(
                    RecentSearchInfo("립밤"),
                    RecentSearchInfo("핸드크림"),
                    RecentSearchInfo("틴트"),
                    RecentSearchInfo("쿠션"),
                    RecentSearchInfo("마스크팩"),
                    RecentSearchInfo("향수"),
                    RecentSearchInfo("스킨케어")

                )
            )
        }

        binding.rvRecentProduct.adapter = RecentProductAdapter(
            this
        ).apply {
            setRecentProductList(
                listOf(
                    RecentProductInfo(
                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
                        "에스트라",
                        "아토베리어365 크림 80ml 더블 기획",
                        30900,
                        30
                    ),
                    RecentProductInfo(
                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
                        "에스트라",
                        "아토베리어365 크림 80ml 더블 기획",
                        30900,
                        30
                    ),
                    RecentProductInfo(
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