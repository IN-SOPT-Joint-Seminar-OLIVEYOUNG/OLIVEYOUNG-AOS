package com.sopt.oliveyoung.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.oliveyoung.data.ServicePool
import com.sopt.oliveyoung.data.dto.response.ResponseSearchDto
import com.sopt.oliveyoung.domain.CosmeticBrandInfo
import com.sopt.oliveyoung.domain.CosmeticProductInfo
import com.sopt.oliveyoung.util.extensions.enqueueUtil
import timber.log.Timber

class SearchViewModel : ViewModel() {
    private val oliveYoungService = ServicePool.oliveYoungService
    private val _searchData = MutableLiveData<ResponseSearchDto?>()
    val searchData: LiveData<ResponseSearchDto?>
        get() = _searchData
    private val _searchProductData = MutableLiveData<List<CosmeticProductInfo>?>()
    val searchProductData: LiveData<List<CosmeticProductInfo>?>
        get() = _searchProductData
    private val _searchResultProductData = MutableLiveData<List<CosmeticProductInfo>?>()
    val searchResultProductData: LiveData<List<CosmeticProductInfo>?>
        get() = _searchResultProductData
    private val _searchResultBrandData = MutableLiveData<List<CosmeticBrandInfo>?>()
    val searchResultBrandData: LiveData<List<CosmeticBrandInfo>?>
        get() = _searchResultBrandData

    init {
        fetchSearchView()
        fetchSearchProduct()
    }

    private fun fetchSearchProduct() {
        oliveYoungService.getSearchList()
            .enqueueUtil({ result ->
                _searchProductData.value = result.data.toCosmeticProductInfo(result.data.products)
                Timber.i("검색 데이터 조회 성공: $result")
            }, { code ->
                Timber.d("검색 데이터 조회 실패: $code")
            })
    }

    private fun fetchSearchView() {
        oliveYoungService.getSearchList()
            .enqueueUtil({ result ->
                _searchData.value = result.data
                Timber.i("검색 데이터 조회 성공: $result")
            }, { code ->
                Timber.d("검색 데이터 조회 실패: $code")
            })
    }

    fun fetchSearchResultProduct(searchKeyword: String) {
        oliveYoungService.getSearchResult(searchKeyword)
            .enqueueUtil({ result ->
                result.data.run {
                    _searchResultProductData.value = toCosmeticProductInfo(result.data.product)
                    _searchResultBrandData.value = toCosmeticBrandInfo(result.data.brand)
                }
                Timber.i("검색 결과 제품 조회 성공: $result")
            }, { code ->
                Timber.d("검색 결과 제품 조회 실패: $code")
            })
    }
}

