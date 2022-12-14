package com.ej.android_cleanarchitecture_newsapiclient.presentation.di

import com.ej.android_cleanarchitecture_newsapiclient.data.repository.NewsRepositoryImpl
import com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasource.NewsLocalDataSource
import com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasource.NewsRemoteDataSource
import com.ej.android_cleanarchitecture_newsapiclient.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ):NewsRepository{
        return NewsRepositoryImpl(newsRemoteDataSource,newsLocalDataSource)
    }
}