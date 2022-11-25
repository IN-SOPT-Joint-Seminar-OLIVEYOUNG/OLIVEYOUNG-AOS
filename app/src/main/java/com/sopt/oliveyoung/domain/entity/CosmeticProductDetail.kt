package com.sopt.oliveyoung.domain.entity

data class CosmeticProductDetail(
    val name: String,
    val brandName: String,
    val mainImg: String,
    val detailImg: String,
    val originalPrice: String,
    val saledPrice: String,
    val salePercent: String,
    val score: String,
    val reviewCount: String,
    val isLiked: Boolean,
)