package com.melihkarakilinc.memesapplication

import androidx.paging.PagingSource

class MemesPagingSource(private val repository: Repository) : PagingSource<Int, Meme>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Meme> {
        val position = params.key ?: STARTING_INDEX
        return try {
            val memes = repository.getMemes()
            LoadResult.Page(
                data = memes.data.memes,
                prevKey = if (position == STARTING_INDEX) null else position - 1,
                nextKey = if (memes.data.memes.isEmpty()) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val STARTING_INDEX = 1
    }
}