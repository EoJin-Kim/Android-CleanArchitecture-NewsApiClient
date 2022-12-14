package com.ej.android_cleanarchitecture_newsapiclient.domain.repository

import androidx.lifecycle.LiveData
import com.ej.android_cleanarchitecture_newsapiclient.data.model.APIResponse
import com.ej.android_cleanarchitecture_newsapiclient.data.model.Article
import com.ej.android_cleanarchitecture_newsapiclient.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(country:String, page:Int,):Resource<APIResponse>
    suspend fun getSearchedNews(country : String,searchQuery:String,page: Int): Resource<APIResponse>
    suspend fun saveNews(article:Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}