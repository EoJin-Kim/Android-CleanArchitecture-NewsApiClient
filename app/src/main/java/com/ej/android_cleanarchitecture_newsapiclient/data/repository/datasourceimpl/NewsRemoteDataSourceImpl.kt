package com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasourceimpl

import com.ej.android_cleanarchitecture_newsapiclient.data.api.NewsAPIService
import com.ej.android_cleanarchitecture_newsapiclient.data.model.APIResponse
import com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,

) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country:String, page:Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country,page)
    }
}