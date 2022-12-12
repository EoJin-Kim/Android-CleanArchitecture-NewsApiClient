package com.ej.android_cleanarchitecture_newsapiclient.domain.usecase

import com.ej.android_cleanarchitecture_newsapiclient.data.model.APIResponse
import com.ej.android_cleanarchitecture_newsapiclient.data.util.Resource
import com.ej.android_cleanarchitecture_newsapiclient.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun excute(): Resource<APIResponse>{
        return newsRepository.getNewsHeadlines()
    }
}