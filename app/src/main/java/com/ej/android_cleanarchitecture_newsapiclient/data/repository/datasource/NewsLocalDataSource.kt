package com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasource

import com.ej.android_cleanarchitecture_newsapiclient.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
    fun getSavedArticles():Flow<List<Article>>
}