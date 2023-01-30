package com.example.data.remote.dataSource

import com.example.data.remote.dto.Data
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 2023-01-27
 * pureum
 */
interface PageDataSource {
//    @GET("character/?page=2")
//    @GET("character/?page={p}")
    @GET("character")
    suspend fun getPageData(
        @Query("page") page: String
    ):Data
}