package com.sopt.oliveyoung.data.dto.response

import com.sopt.oliveyoung.domain.CosmeticBrandInfo
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBrandDto(
    val name: String,
    val brandImg: String,
    val products: List<ResponseProductDto>,
) {
    fun toBrandInfo(brand: ResponseBrandDto) = CosmeticBrandInfo(
        brand.brandImg,
        brand.name
    )
}
