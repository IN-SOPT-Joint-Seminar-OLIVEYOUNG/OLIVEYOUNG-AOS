package com.sopt.oliveyoung.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseProductLikeStateDto(
    val isLiked: Boolean
)