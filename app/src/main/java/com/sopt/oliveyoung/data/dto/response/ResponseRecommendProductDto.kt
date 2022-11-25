package com.sopt.oliveyoung.data.dto.response

import com.sopt.oliveyoung.domain.CosmeticProductInfo
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRecommendProductDto(

    val brandName: String,
    val mainImg: String,
    val name: String,
    val saledPrice: String,
    val salePercent: String,
) {

    fun toCosmeticProductInfo(recommendProductDto: ResponseRecommendProductDto) =
        CosmeticProductInfo(
            mainImg,
            brandName,
            name,
            saledPrice,
            salePercent

        )
}
