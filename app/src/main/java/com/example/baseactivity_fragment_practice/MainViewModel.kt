package com.example.baseactivity_fragment_practice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseactivity_fragment_practice.dto.AppData
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
    private val list = arrayListOf<AppData>()
    private var _data = MutableLiveData<ArrayList<AppData>>()
    val data : LiveData<ArrayList<AppData>>
        get() = _data

    fun myGetData(page:String = "1"){
        viewModelScope.launch {
            var useCaseData = useCase(page)
            Log.e("TAG", "myGetData: $useCaseData , page : $page", )
            for(i  in 0 until useCaseData.name.size)
                list.add(AppData(
                    type = i%3,
                    name = useCaseData.name[i],
                    status = useCaseData.status[i],
                    species = useCaseData.species[i],
                    image = useCaseData.image[i]
                    ))
            _data.value = list
            //_data.value = useCase(page)
            //Log.e("TAG", "myGetData: ${_data.value}")
        }
    }
}