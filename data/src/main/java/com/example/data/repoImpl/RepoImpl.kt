package com.example.data.repoImpl

import com.example.data.remote.dataSourceImpl.PageDataSourceImpl
import com.example.data.remote.dto.toDomainData
import com.example.domain.model.DomainData
import com.example.domain.repo.PageDataRepo

/**
 * 2023-01-27
 * pureum
 */
class RepoImpl : PageDataRepo{
    override suspend fun getData(): DomainData {
        return PageDataSourceImpl().getPageData().toDomainData()
    }
}