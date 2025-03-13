package com.example.socialview.paging

import androidx.lifecycle.LiveData
import com.example.socialview.utils.Resource

class PagingLiveData<T>() : LiveData<Resource<T>>() {

    var pages: Int = 0
    var currentPage: Int = 1

    fun setValues(data: T?) {
        postValue( Resource.success(data))
    }

    fun thereIsMoreData(): Boolean {
        return currentPage <= pages && pages > 1
    }

    fun clearData() {
        postValue(Resource.success(null))
        pages = 0
        currentPage = 1
    }
}

class CustomPagingLiveData<T>() : LiveData<T>() {

    var pages: Int = 0
    var currentPage: Int = 1

    fun setValues(data: T?) {
        postValue( data)
    }

    fun thereIsMoreData(): Boolean {
        return currentPage <= pages && pages > 1
    }

    fun clearData() {
        postValue(null)
        pages = 0
        currentPage = 1
    }
}