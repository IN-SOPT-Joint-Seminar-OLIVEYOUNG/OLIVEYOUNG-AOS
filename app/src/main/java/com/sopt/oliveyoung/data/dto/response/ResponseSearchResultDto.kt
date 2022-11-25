package com.sopt.oliveyoung.data.dto.response

import com.sopt.oliveyoung.domain.CosmeticBrandInfo
import com.sopt.oliveyoung.domain.CosmeticProductInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchResultDto(
    @SerialName("brands")
    val brand: List<Brand>,
    @SerialName("products")
    val product: List<Product>,
) {
    @Serializable
    data class Brand(
        val name: String,
        val brandImg: String,
    )

    @Serializable
    data class Product(
        val brandName: String,
        val name: String,
        val saledPrice: String,
        val salePercent: String,
        val mainImg: String,
    )

    fun toCosmeticProductInfo(products: List<Product>) =
        products.map { product ->
            CosmeticProductInfo(
                product.mainImg,
                product.brandName,
                product.name,
                product.saledPrice,
                product.salePercent
            )
        }

    fun toCosmeticBrandInfo(brands: List<Brand>) =
        brands.map { brand ->
            CosmeticBrandInfo(
                brand.brandImg,
                brand.name
            )
        }
}
