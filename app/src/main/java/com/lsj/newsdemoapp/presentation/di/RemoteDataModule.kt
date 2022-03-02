package com.lsj.newsdemoapp.presentation.di

import com.lsj.newsdemoapp.data.api.NewsAPIService
import com.lsj.newsdemoapp.data.repository.dataSource.NewsRemoteDataSource
import com.lsj.newsdemoapp.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsAPIService: NewsAPIService
    ): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}