package com.sopt.oliveyoung.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.oliveyoung.data.OliveYoungService
import com.sopt.oliveyoung.data.ServicePool
import com.sopt.oliveyoung.domain.CosmeticProductInfo
import com.sopt.oliveyoung.domain.entity.CosmeticProductDetail
import com.sopt.oliveyoung.util.extensions.enqueueUtil
import timber.log.Timber

class ProductDetailViewModel : ViewModel() {
    private val oliveYoungService = ServicePool.oliveYoungService

    private val _productDetail = MutableLiveData<CosmeticProductDetail>()
    val productDetail: LiveData<CosmeticProductDetail> get() = _productDetail

    private val _similarProduct = MutableLiveData<List<CosmeticProductInfo>?>()
    val similarProduct: LiveData<List<CosmeticProductInfo>?>
        get() = _similarProduct

    private val _recommendProduct = MutableLiveData<List<CosmeticProductInfo>?>()
    val recommendProduct: LiveData<List<CosmeticProductInfo>?>
        get() = _recommendProduct

    init {
        fetchProductDetail()
    }

    private fun fetchProductDetail() {
        oliveYoungService.getProductDetail(1) // 어떤 아이템을 클릭해도 itemId가 1인 상품의 상세 데이터를 보내주는 것으로 서버팀과 논의 후 결정함
            .enqueueUtil({ result ->
                result.data.run {
                    _productDetail.value = toProductDetail(product)
                    _similarProduct.value = toCosmeticProductInfoFromSimilars(similars)
                    _recommendProduct.value = toCosmeticProductInfoFromRecommends(recommends)
                }
                Timber.i("상품 상세정보 조회 성공: $result")
            }, { code ->
                Timber.d("상품 상세정보 조회 실패: $code")
            })
    }
}

