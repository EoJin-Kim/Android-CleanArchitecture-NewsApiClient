package com.ej.android_cleanarchitecture_newsapiclient.presentation.di

import com.ej.android_cleanarchitecture_newsapiclient.data.db.ArticleDAO
import com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasource.NewsLocalDataSource
import com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasourceimpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provdeLocalDataSource(articleDAO: ArticleDAO): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDAO)
    }
}