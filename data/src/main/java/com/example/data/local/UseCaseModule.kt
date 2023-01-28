package com.example.data.local

import com.example.data.remote.dataSource.PageDataSource
import com.example.data.remote.dataSourceImpl.PageDataSourceImpl
import com.example.data.repoImpl.RepoImpl
import com.example.domain.repo.PageDataRepo
import com.example.domain.use_case.GetPageDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * 2023-01-28
 * pureum
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideUseCase(repository : PageDataSource): PageDataRepo{
        return RepoImpl(repository)
    }
}