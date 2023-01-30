package com.example.baseactivity_fragment_practice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainData
import com.example.domain.use_case.GetPageDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 2023-01-26
 * pureum
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetPageDataUseCase
) : ViewModel() {

    private var _data = MutableLiveData<DomainData?>()
    val data : LiveData<DomainData?>
        get() = _data

    fun myGetData(page:String = "1"){
        viewModelScope.launch {
            _data.value = useCase(page)
            Log.e("TAG", "myGetData: ${_data.value}")
        }
    }
}