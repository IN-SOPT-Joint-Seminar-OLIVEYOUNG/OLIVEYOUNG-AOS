package com.sopt.oliveyoung.presentation

import android.os.Bundle
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivitySearchBinding
import com.sopt.oliveyoung.domain.PopularSearchInfo
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

    }
}