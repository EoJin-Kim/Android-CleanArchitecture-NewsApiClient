package com.ej.android_cleanarchitecture_newsapiclient.domain.usecase

import com.ej.android_cleanarchitecture_newsapiclient.data.model.APIResponse
import com.ej.android_cleanarchitecture_newsapiclient.data.util.Resource
import com.ej.android_cleanarchitecture_newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun excute(country:String, searchQuery:String, page:Int):Resource<APIResponse>{
        return newsRepository.getSearchedNews(country,searchQuery,page)
    }


}