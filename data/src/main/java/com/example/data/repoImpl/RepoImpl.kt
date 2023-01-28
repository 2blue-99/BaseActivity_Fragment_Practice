package com.example.data.repoImpl

import com.example.data.remote.dataSource.PageDataSource
import com.example.data.remote.dataSourceImpl.PageDataSourceImpl
import com.example.data.remote.dto.toDomainData
import com.example.domain.model.DomainData
import com.example.domain.repo.PageDataRepo
import javax.inject.Inject

/**
 * 2023-01-27
 * pureum
 */
class RepoImpl @Inject constructor(
    private val api : PageDataSource
) : PageDataRepo{
    override suspend fun getData(): DomainData {
        return api.getPageData().toDomainData()
    }
}