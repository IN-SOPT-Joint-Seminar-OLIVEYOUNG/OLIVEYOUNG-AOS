package com.sopt.oliveyoung.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.oliveyoung.data.ServicePool
import com.sopt.oliveyoung.data.dto.response.ResponseSearchDto
import com.sopt.oliveyoung.domain.CosmeticProductInfo
import com.sopt.oliveyoung.util.extensions.enqueueUtil
import timber.log.Timber

class HomeViewModel : ViewModel() {
    private val oliveYoungService = ServicePool.oliveYoungService
    private val _recommendproductList = MutableLiveData<List<CosmeticProductInfo>?>()
    val recommendProductList: LiveData<List<CosmeticProductInfo>?> get() = _recommendproductList

    init {
        fetchSearchView()
    }

    private fun fetchSearchView() {
        oliveYoungService.getMainRecommendProductList().enqueueUtil({ result ->
            _recommendproductList.value = result.data.map { it.toCosmeticProductInfo(it) }
            Timber.i(message = "추천 상품 조회 성공: $result")
        }, { code ->
            Timber.d(message = "추천 상품 조회 살패: $code")
        })
    }
}

