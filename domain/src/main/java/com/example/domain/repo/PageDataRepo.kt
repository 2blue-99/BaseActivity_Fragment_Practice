package com.example.domain.repo

import com.example.domain.model.DomainData

/**
 * 2023-01-27
 * pureum
 */
interface PageDataRepo {
    suspend fun getData(page:String):DomainData
}