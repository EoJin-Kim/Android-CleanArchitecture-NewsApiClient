package com.ej.android_cleanarchitecture_newsapiclient.presentation.di

import com.ej.android_cleanarchitecture_newsapiclient.data.api.NewsAPIService
import com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasource.NewsRemoteDataSource
import com.ej.android_cleanarchitecture_newsapiclient.data.repository.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewRemoteDataSource(newsAPIService: NewsAPIService):NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsAPIService)
    }

}