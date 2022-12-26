package com.ominext.moviedb.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ominext.moviedb.common.DebugLog
import com.ominext.moviedb.common.utils.SingleLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.plus

abstract class BaseViewModel : ViewModel() {


    val mLoading = SingleLiveData<Boolean>()
    val mError = SingleLiveData<Throwable>()

    private val debugLog: DebugLog by lazy { DebugLog() }

    private val exceptionHandler = CoroutineExceptionHandler { _, t ->
        mError.value = t
    }

    protected val scope = viewModelScope.plus(exceptionHandler)
}
