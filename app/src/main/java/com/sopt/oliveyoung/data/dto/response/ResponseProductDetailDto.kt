package com.sopt.oliveyoung.data.dto.response

import com.sopt.oliveyoung.domain.CosmeticProductInfo
import com.sopt.oliveyoung.domain.entity.CosmeticProductDetail
import kotlinx.serialization.Serializable

@Serializable
data class ResponseProductDetailDto(
    val product: Product,
    val recommends: List<RecommendProduct>,
    val similars: List<SimilarProduct>,
) {
    @Serializable
    data class Product(
        val brandName: String,
        val detailImg: String,
        val detailImgHeight: Int?,
        val detailImgWidth: Int?,
        val isLiked: Boolean,
        val mainImg: String,
        val name: String,
        val originalPrice: String,
        val rate: Double,
        val reviewCount: String,
        val salePercent: String,
        val saledPrice: String,
    )

    @Serializable
    data class RecommendProduct(
        val brandName: String,
        val mainImg: String,
        val name: String,
        val salePercent: String?,
        val saledPrice: String,
    )

    @Serializable
    data class SimilarProduct(
        val brandName: String,
        val mainImg: String,
        val name: String,
        val salePercent: String,
        val saledPrice: String,
    )

    fun toProductDetail(product: Product) = CosmeticProductDetail(product.name,
        product.brandName,
        product.mainImg,
        product.detailImg,
        product.originalPrice,
        product.saledPrice,
        product.salePercent,
        product.rate.toString(),
        product.reviewCount,
        product.isLiked)

    fun toCosmeticProductInfoFromRecommends(products: List<RecommendProduct>) =
        products.map { product ->
            CosmeticProductInfo(product.mainImg,
                product.brandName,
                product.name,
                product.saledPrice)
        }

    fun toCosmeticProductInfoFromSimilars(products: List<SimilarProduct>) =
        products.map { product ->
            CosmeticProductInfo(product.mainImg,
                product.brandName,
                product.name,
                product.saledPrice,
                product.salePercent)
        }
}
