package com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasource

import com.ej.android_cleanarchitecture_newsapiclient.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse>
    suspend fun getSearchedNews(country: String,searchQuery:String, page: Int): Response<APIResponse>
}