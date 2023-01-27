package com.example.baseactivity_fragment_practice

import com.example.baseactivity_fragment_practice.DAO.API_Data
import retrofit2.Call
import retrofit2.http.GET

/**
 * 2023-01-26
 * pureum
 */
interface RetrofitInter  {
    @GET("character/?page=2")
    fun getData() : Call<API_Data>?
}