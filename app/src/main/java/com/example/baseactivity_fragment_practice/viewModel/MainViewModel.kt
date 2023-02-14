package com.example.baseactivity_fragment_practice.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.baseactivity_fragment_practice.dto.AppData
import com.example.baseactivity_fragment_practice.room.Database
import com.example.baseactivity_fragment_practice.room.Entity
import com.example.baseactivity_fragment_practice.room.MyDao
import com.example.baseactivity_fragment_practice.viewModel.base.BaseMainVeiwModel
import com.example.domain.model.DomainData
import com.example.domain.use_case.GetPageDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 2023-01-26
 * pureum
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetPageDataUseCase
) : BaseMainVeiwModel() {
    private var db: MyDao?= null
    private val list = arrayListOf<DomainData>()
    private var _data = MutableLiveData<List<DomainData>>()
    val data : LiveData<List<DomainData>>
        get() = _data
    private var _getAllData = MutableLiveData<List<Entity>?>()
    val getAllData : LiveData<List<Entity>?>
        get() = _getAllData

    fun myGetData(page:String = "1"){
        viewModelScope.launch(exceptionHandler){
            val useCaseData = useCase(page)
            list.clear()
            _data.value = useCaseData
        }
    }

    fun insertData(list:DomainData){
        CoroutineScope(exceptionHandler).launch {
            if(db==null) { return@launch }
            val pureum = db?.insert(Entity(list.name, list.status, list.species, list.image))
            //Log.e("TAG", "insertData: 성공 $pureum", )
        }
    }

    fun getAllData() {
        CoroutineScope(exceptionHandler).launch {
            Log.e("TAG", "getAllData: 시도",)
            val pureum = db?.getAll()
            Log.e("TAG", "getAllData: $pureum", )
            if (pureum != null) _getAllData.postValue(pureum)
        }
    }

    fun initDB(database : Database){
        db = database.pureumDao()
    }
}