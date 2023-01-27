package com.example.data.remote.dataSourceImpl

import com.example.data.remote.dataSource.PageDataSource
import com.example.data.remote.dto.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * 2023-01-27
 * pureum
 */
class PageDataSourceImpl : PageDataSource{
    override suspend fun getPageData(): Data {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PageDataSource::class.java).getPageData()
    }
}