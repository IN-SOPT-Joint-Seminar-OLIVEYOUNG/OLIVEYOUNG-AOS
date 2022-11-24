package com.sopt.oliveyoung.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.oliveyoung.data.ServicePool
import com.sopt.oliveyoung.data.dto.response.ResponseSearchDto
import com.sopt.oliveyoung.util.extensions.enqueueUtil
import timber.log.Timber

class SearchViewModel : ViewModel() {
    val SearchData = MutableLiveData<ResponseSearchDto?>()
    val _SearchData: LiveData<ResponseSearchDto?>
        get() = SearchData
    private val oliveYoungService = ServicePool.oliveYoungService

    init{
        Timber.d("hello1")
        fetchSearchView()
    }

    private fun fetchSearchView() {
        Timber.d("hello2")
        oliveYoungService.getSearchList()
            .enqueueUtil({ result ->
                SearchData.value = result.data
                Timber.i("검색 데이터 조회 성공: $result")
            }, { code ->
                Timber.d("검색 데이터 조회 실패: $code")
            })
    }
}

