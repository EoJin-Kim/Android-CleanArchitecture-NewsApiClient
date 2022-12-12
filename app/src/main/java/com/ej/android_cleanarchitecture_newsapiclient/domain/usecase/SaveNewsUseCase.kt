package com.ej.android_cleanarchitecture_newsapiclient.domain.usecase

import com.ej.android_cleanarchitecture_newsapiclient.data.model.Article
import com.ej.android_cleanarchitecture_newsapiclient.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun excute(article:Article) = newsRepository.saveNews(article)
}