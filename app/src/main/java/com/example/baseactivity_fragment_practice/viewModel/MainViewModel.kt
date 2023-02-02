package com.example.baseactivity_fragment_practice.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.baseactivity_fragment_practice.dto.AppData
import com.example.baseactivity_fragment_practice.viewModel.base.BaseMainVeiwModel
import com.example.domain.model.DomainData
import com.example.domain.use_case.GetPageDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.SocketException
import javax.inject.Inject

/**
 * 2023-01-26
 * pureum
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetPageDataUseCase
) : BaseMainVeiwModel() {
    private val list = arrayListOf<DomainData>()
    private var _data = MutableLiveData<List<DomainData>>()
    val data : LiveData<List<DomainData>>
        get() = _data

    fun myGetData(page:String = "1"){
        viewModelScope.launch(exceptionHandler){
            val useCaseData = useCase(page)
            list.clear()
//            for(i  in 0 until useCaseData.name.size)
//                list.add(AppData(
//                    type = i%3,
//                    name = useCaseData.name[i],
//                    status = useCaseData.status[i],
//                    species = useCaseData.species[i],
//                    image = useCaseData.image[i]
//                    ))
            _data.value = useCaseData
        }
    }

    fun test(){
        viewModelScope.launch(exceptionHandler) {
            throw SocketException()
        }
    }
}