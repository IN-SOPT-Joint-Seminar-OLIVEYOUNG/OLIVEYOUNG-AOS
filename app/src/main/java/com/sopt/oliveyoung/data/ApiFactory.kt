package com.sopt.oliveyoung.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.oliveyoung.BuildConfig.BASE_URL
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiFactory {
    @OptIn(ExperimentalSerializationApi::class)
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://13.125.97.174:3000")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    val oliveYoungService = ApiFactory.create<OliveYoungService>()
}