package com.example.data.local

import com.example.data.remote.dataSource.PageDataSource
import com.example.data.repoImpl.RepoImpl
import com.example.domain.repo.PageDataRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 2023-01-30
 * pureum
 */

@Module
@InstallIn(SingletonComponent::class)
object RepoMoudule {
    @Provides
    @Singleton
    fun provideRepository(api: PageDataSource):PageDataRepo{
        return RepoImpl(api)
    }

}