package com.example.domain.use_case

import com.example.domain.model.DomainData
import com.example.domain.repo.PageDataRepo
import javax.inject.Inject

/**
 * 2023-01-27
 * pureum
 */
class GetPageDataUseCase @Inject constructor(
    private val repository : PageDataRepo
    ) {
    suspend operator fun invoke() : DomainData{
        return repository.getData()
    }
}