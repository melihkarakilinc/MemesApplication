package com.melihkarakilinc.memesapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.melihkarakilinc.memesapplication.Adapter.MemesPagingSource
import com.melihkarakilinc.memesapplication.Meme
import com.melihkarakilinc.memesapplication.RemoteData.AppConfig
import com.melihkarakilinc.memesapplication.Repository.Repository
import kotlinx.coroutines.flow.Flow

class MainViewModel() : ViewModel() {

   private val repository = Repository(
        AppConfig.ApiService()
    )

    init {
        getMemes()
    }

    fun getMemes(): Flow<PagingData<Meme>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { MemesPagingSource(repository) }
        ).flow
            .cachedIn(viewModelScope)
    }

    companion object {
        const val PAGE_SIZE = 0
    }
}