package com.example.data.remote.dataSourceImpl

import android.util.Log
import com.example.data.remote.dataSource.PageDataSource
import com.example.data.remote.dto.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

/**
 * 2023-01-27
 * pureum
 */
class PageDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
): PageDataSource{
    override suspend fun getPageData(page:String): Data {
        return retrofit.create(PageDataSource::class.java).getPageData(page)
    }
}