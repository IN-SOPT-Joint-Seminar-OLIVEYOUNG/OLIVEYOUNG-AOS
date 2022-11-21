package com.sopt.oliveyoung.presentation

import android.os.Bundle
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivityDetailBinding
import com.sopt.oliveyoung.domain.CosmeticProductInfo
import com.sopt.oliveyoung.util.binding.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners() {
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.viewHashtag.setHashtag(listOf("립밤", "핸드크림", "틴트", "쿠션", "마스크팩"))
        // TODO 어뎁터 생성자에서 context 프로퍼티 제거 및 CosmeticProductInfo 프로퍼티의 데이터 타입을 전부 String으로 수정
        binding.rvSimilarProductList.adapter = CosmeticProductAdapter(this).apply {
            setCosmeticList(listOf(CosmeticProductInfo("", "피지오겔", "[한정기획] AI크림 100ml 기획", 27000, 23), CosmeticProductInfo("", "피지오겔", "[한정기획] AI크림 100ml 기획", 27000, 23), CosmeticProductInfo("", "피지오겔", "[한정기획] AI크림 100ml 기획", 27000, 23)))
        }
        binding.rvRecommendProductList.adapter = CosmeticProductAdapter(this).apply {
            setCosmeticList(listOf(CosmeticProductInfo("", "피지오겔", "[한정기획] AI크림 100ml 기획", 27000, 23), CosmeticProductInfo("", "피지오겔", "[한정기획] AI크림 100ml 기획", 27000, 23), CosmeticProductInfo("", "피지오겔", "[한정기획] AI크림 100ml 기획", 27000, 23)))
        }
    }
}