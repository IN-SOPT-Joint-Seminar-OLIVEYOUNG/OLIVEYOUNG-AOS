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
    fun toCosmeticProductInfo(product: ResponseRecommendProductDto) =
        CosmeticProductInfo(
            product.mainImg,
            product.brandName,
            product.name,
            product.saledPrice,
            product.salePercent
        )
}
