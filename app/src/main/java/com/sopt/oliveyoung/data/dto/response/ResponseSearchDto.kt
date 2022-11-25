package com.sopt.oliveyoung.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchDto(
    val recentWords: List<String>,
    val products: List<Product>
) {
    @Serializable
    data class Product(
        val brandName: String,
        val mainImg: String,
        val name: String,
        val saledPrice: String,
        val salePercent: String,
    )
}