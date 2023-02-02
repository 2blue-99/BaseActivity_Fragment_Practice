package com.example.baseactivity_fragment_practice.viewModel.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException

/**
 * 2023-01-31
 * pureum
 */
abstract class BaseMainVeiwModel : ViewModel() {
    protected val _fetchState = MutableLiveData<Pair<Throwable, FetchState>>()
    val fetchState : LiveData<Pair<Throwable, FetchState>>
        get() = _fetchState

    protected  val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        Log.e("TAG", "$throwable: ", )
        when(throwable){
            is SocketException -> _fetchState.postValue(Pair(throwable, FetchState.BAD_INTERNET))
            is HttpException -> _fetchState.postValue(Pair(throwable, FetchState.PARSE_ERROR))
            is UnknownHostException -> _fetchState.postValue(Pair(throwable,
                FetchState.WRONG_CONNECTION
            ))
            else -> _fetchState.postValue(Pair(throwable, FetchState.FAIL))
        }
    }
}