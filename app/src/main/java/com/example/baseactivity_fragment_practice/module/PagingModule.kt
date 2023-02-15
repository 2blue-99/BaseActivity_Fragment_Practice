package com.example.baseactivity_fragment_practice.module

import com.example.baseactivity_fragment_practice.paging3.PagingRepository
import com.example.domain.use_case.GetPageDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 2023-02-15
 * pureum
 */
@Module
@InstallIn(SingletonComponent::class)
object PagingModule {
    @Provides
    @Singleton
    fun providePagingRepo(useCase:GetPageDataUseCase) : PagingRepository{
        return PagingRepository(useCase)
    }
}