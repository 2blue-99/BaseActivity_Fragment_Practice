package com.example.baseactivity_fragment_practice.paging3

import android.provider.ContactsContract
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.remote.dataSource.PageDataSource
import com.example.data.remote.dto.Data
import com.example.domain.model.DomainData
import com.example.domain.use_case.GetPageDataUseCase
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject

/**
 * 2023-02-15
 * pureum
 */
class MyPagingSource (
    private val page:String,
    private val useCase: GetPageDataUseCase
) :PagingSource<Int, DomainData>() {
    override fun getRefreshKey(state: PagingState<Int, DomainData>): Int? = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DomainData> {
        return try {
            val now = params.key?:0
            val api = useCase.invoke(page)
            LoadResult.Page(
                data = api,
                prevKey = if(now == 0) null else now-1,
                nextKey = now+1
            )
        }catch (e:Exception){
            Log.e("TAG", "load: $e", )
            LoadResult.Error(e)
        }
    }
}