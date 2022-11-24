package com.sopt.oliveyoung.data

import com.sopt.oliveyoung.data.dto.response.ResponseBase
import com.sopt.oliveyoung.data.dto.response.ResponseSearchDto
import retrofit2.Call
import retrofit2.http.GET

interface OliveYoungService {
    @GET("/search/main")
    fun getSearchList(): Call<ResponseBase<ResponseSearchDto>>
}