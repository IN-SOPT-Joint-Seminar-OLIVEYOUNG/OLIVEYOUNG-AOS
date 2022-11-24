package com.sopt.oliveyoung.presentation

import android.os.Bundle
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivitySearchResultBinding
import com.sopt.oliveyoung.domain.CosmeticBrandInfo
import com.sopt.oliveyoung.domain.CosmeticProductInfo
import com.sopt.oliveyoung.util.binding.BindingActivity

class SearchResultActivity :
    BindingActivity<ActivitySearchResultBinding>(R.layout.activity_search_result) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        binding.rvCosmeticProduct.adapter = CosmeticProductAdapter(
            this
        ).apply {
//            setCosmeticList(
//                listOf(
//                    CosmeticProductInfo(
//                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
//                        "에스트라",
//                        "아토베리어365 크림 80ml 더블 기획",
//                        30900,
//                        30
//                    ),
//                    CosmeticProductInfo(
//                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
//                        "에스트라",
//                        "아토베리어365 크림 80ml 더블 기획",
//                        30900,
//                        30
//                    ),
//                    CosmeticProductInfo(
//                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
//                        "에스트라",
//                        "아토베리어365 크림 80ml 더블 기획",
//                        30900,
//                        30
//                    ),
//                    CosmeticProductInfo(
//                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
//                        "에스트라",
//                        "아토베리어365 크림 80ml 더블 기획",
//                        30900,
//                        30
//                    ),
//                    CosmeticProductInfo(
//                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
//                        "에스트라",
//                        "아토베리어365 크림 80ml 더블 기획",
//                        30900,
//                        30
//                    ),
//                    CosmeticProductInfo(
//                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
//                        "에스트라",
//                        "아토베리어365 크림 80ml 더블 기획",
//                        30900,
//                        30
//                    ),
//                    CosmeticProductInfo(
//                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
//                        "에스트라",
//                        "아토베리어365 크림 80ml 더블 기획",
//                        30900,
//                        30
//                    ),
//                    CosmeticProductInfo(
//                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
//                        "에스트라",
//                        "아토베리어365 크림 80ml 더블 기획",
//                        30900,
//                        30
//                    )
//                )
//            )
        }
        binding.rvCosmeticBrand.adapter = CosmeticBrandAdapter(this).apply {
            setCosmeticBrandList(
                listOf(
                    CosmeticBrandInfo(
                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
                        "바이오더마"
                    ),
                    CosmeticBrandInfo(
                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
                        "바이오더마"
                    ),
                    CosmeticBrandInfo(
                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
                        "바이오더마"
                    ),
                    CosmeticBrandInfo(
                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
                        "바이오더마"
                    ),
                    CosmeticBrandInfo(
                        "https://image.oliveyoung.co.kr/uploads/images/display/90000020246/356/8519185861847839856.jpg",
                        "바이오더마"
                    ),
                )
            )
        }
    }
}