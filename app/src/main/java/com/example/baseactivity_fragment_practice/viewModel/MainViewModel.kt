package com.example.baseactivity_fragment_practice.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.baseactivity_fragment_practice.paging3.PagingRepository
import com.example.baseactivity_fragment_practice.room.Database
import com.example.baseactivity_fragment_practice.room.Entity
import com.example.baseactivity_fragment_practice.room.MyDao
import com.example.baseactivity_fragment_practice.viewModel.base.BaseMainVeiwModel
import com.example.domain.model.DomainData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 2023-01-26
 * pureum
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val pagingRepo: PagingRepository
) : BaseMainVeiwModel() {
    private var db: MyDao?= null
    private val list = arrayListOf<DomainData>()
    private var _data = MutableLiveData<PagingData<DomainData>>()
    val data : LiveData<PagingData<DomainData>>
        get() = _data
    private var _getAllData = MutableLiveData<List<Entity>?>()
    val getAllData : LiveData<List<Entity>?>
        get() = _getAllData

    fun myGetData(page: String = "1"): Flow<PagingData<DomainData>> {
        return pagingRepo.repoGetData(page).cachedIn(viewModelScope)
    }

    fun insertData(list:DomainData){
        CoroutineScope(exceptionHandler).launch {
            if(db==null) { return@launch }
            db?.insert(Entity(list.name, list.status, list.species, list.image))
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

    fun removeData(name:String) {
        CoroutineScope(exceptionHandler).launch {
            Log.e("TAG", "removeData: 시도",)
            val pureum = db?.deleteData(name)
            Log.e("TAG", "removeData: $pureum", )
        }
    }

    fun initDB(database : Database){
        db = database.pureumDao()
    }
}