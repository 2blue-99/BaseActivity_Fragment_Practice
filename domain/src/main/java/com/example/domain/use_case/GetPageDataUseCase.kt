package com.example.domain.use_case

import android.util.Log
import com.example.domain.model.DomainData
import com.example.domain.repo.PageDataRepo

/**
 * 2023-01-27
 * pureum
 */
class GetPageDataUseCase (private val repository : PageDataRepo) {
    suspend operator fun invoke(page:String) : List<DomainData>{
        return repository.getData(page)
    }
}