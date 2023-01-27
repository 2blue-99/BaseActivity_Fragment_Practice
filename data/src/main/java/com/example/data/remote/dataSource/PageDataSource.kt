package com.example.data.remote.dataSource

import com.example.data.remote.dto.Data
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * 2023-01-27
 * pureum
 */
interface PageDataSource {
    @GET("character/?page=2")
    suspend fun getPageData():Data
}