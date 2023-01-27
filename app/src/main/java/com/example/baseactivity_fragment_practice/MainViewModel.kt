package com.example.baseactivity_fragment_practice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseactivity_fragment_practice.DAO.API_Data
import com.example.baseactivity_fragment_practice.DAO.Data
import com.example.data.repoImpl.RepoImpl
import com.example.domain.model.DomainData
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 2023-01-26
 * pureum
 */
class MainViewModel : ViewModel() {

    private var _data = MutableLiveData<DomainData>()
    val data : LiveData<DomainData>
        get() = _data

    private val _pureum_and_hyein = MutableLiveData<API_Data>()
    val pureum_hyein : LiveData<API_Data>
        get() = _pureum_and_hyein

    fun myGetData(){
        viewModelScope.launch {
            _data.value = RepoImpl().getData()
        }
    }



//    override fun getData(): Call<API_Data>? {
//        val data = Retrofit.Builder()
//            .baseUrl("https://rickandmortyapi.com/api/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(RetrofitInter::class.java).getData()?.enqueue(object : Callback<API_Data>{
//                override fun onResponse(call: Call<API_Data>, response: Response<API_Data>) {
//                    Log.e("TAG", "onResponse: ${response.body().toString()}", )
//                }
//
//                override fun onFailure(call: Call<API_Data>, t: Throwable) {
//                    Log.e("TAG", "err : $t", )
//                }
//
//            })
//        //_pureum_and_hyein.value = data
//        data
//        return null
//    }
}