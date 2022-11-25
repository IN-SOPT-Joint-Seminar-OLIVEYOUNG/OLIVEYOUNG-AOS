package com.sopt.oliveyoung.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.oliveyoung.data.ServicePool
import com.sopt.oliveyoung.domain.CosmeticBrandInfo
import com.sopt.oliveyoung.domain.CosmeticProductInfo
import com.sopt.oliveyoung.util.extensions.enqueueUtil
import timber.log.Timber

class HomeViewModel : ViewModel() {
    private val oliveYoungService = ServicePool.oliveYoungService
    private val _recommendProductList = MutableLiveData<List<CosmeticProductInfo>?>()
    val recommendProductList: LiveData<List<CosmeticProductInfo>?> get() = _recommendProductList
    private val _brandList = MutableLiveData<List<CosmeticBrandInfo>?>()
    val brandList: LiveData<List<CosmeticBrandInfo>?> get() = _brandList
    private val _brandProductList = MutableLiveData<List<CosmeticProductInfo>?>()
    val brandProductList: LiveData<List<CosmeticProductInfo>?> get() = _brandProductList

    init {
        fetchRecommendProductList()
        fetchBrandList()
    }

    private fun fetchRecommendProductList() {
        oliveYoungService.getRecommendProductList().enqueueUtil({ result ->
            _recommendProductList.value = result.data.map { it.toCosmeticProductInfo(it) }
            Timber.i(message = "추천 상품 조회 성공: $result")
        }, { code ->
            Timber.d(message = "추천 상품 조회 살패: $code")
        })
    }

    private fun fetchBrandList() {
        oliveYoungService.getBrandList().enqueueUtil({ result ->
            result.data.run {
                _brandList.value = map {
                    it.toBrandInfo(it)
                }
                _brandProductList.value = map { it.products.map { it.toCosmeticProductInfo(it) } }[0] // 0번 인덱스 브랜드의 상품 리스트만 가져오는 이유는 0번 이외의 다른 인덱스에 해당하는 브래드의 상품 정보는 서버에서 보내주지 않기 때문 (서버팀과 합의 본 사항)
            }
            Timber.i(message = "추천 상품 조회 성공: $result")
        }, { code ->
            Timber.d(message = "추천 상품 조회 살패: $code")
        })
    }
}

