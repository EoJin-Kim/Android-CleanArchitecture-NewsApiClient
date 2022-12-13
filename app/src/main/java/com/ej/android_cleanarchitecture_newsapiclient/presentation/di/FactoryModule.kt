package com.ej.android_cleanarchitecture_newsapiclient.presentation.di

import android.app.Application
import com.ej.android_cleanarchitecture_newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.ej.android_cleanarchitecture_newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
    ):NewsViewModelFactory{
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase
        )
    }
}