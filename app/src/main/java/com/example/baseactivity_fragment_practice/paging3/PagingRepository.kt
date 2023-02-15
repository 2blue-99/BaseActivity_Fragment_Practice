package com.example.baseactivity_fragment_practice.paging3

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.domain.model.DomainData
import com.example.domain.use_case.GetPageDataUseCase
import kotlinx.coroutines.flow.Flow

/**
 * 2023-02-15
 * pureum
 */
class PagingRepository(
    private val useCase: GetPageDataUseCase
) {
    fun repoGetData(page:String): Flow<PagingData<DomainData>> {
        return Pager(
            config = PagingConfig(pageSize = 2, enablePlaceholders = false),
            pagingSourceFactory = {MyPagingSource(page, useCase)}
        ).flow
    }
}