package com.sopt.oliveyoung.data

import com.sopt.oliveyoung.data.dto.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface OliveYoungService {
    @GET("/search/main")
    fun getSearchList(): Call<ResponseBase<ResponseSearchDto>>

    @GET("/product/{id}")
    fun getProductDetail(@Path("id") itemId: Int): Call<ResponseBase<ResponseProductDetailDto>>

    @PUT("/product/{id}/isLike")
    fun updateProductLikeState(@Path("id") itemId: Int): Call<ResponseBase<ResponseProductLikeStateDto>>
}