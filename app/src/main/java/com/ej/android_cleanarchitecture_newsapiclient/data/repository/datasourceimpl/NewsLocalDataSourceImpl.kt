package com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasourceimpl

import com.ej.android_cleanarchitecture_newsapiclient.data.db.ArticleDAO
import com.ej.android_cleanarchitecture_newsapiclient.data.model.Article
import com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDAO:ArticleDAO
) : NewsLocalDataSource {

    override suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDAO.getAllArticles()
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        articleDAO.deleteArticle(article)
    }
}