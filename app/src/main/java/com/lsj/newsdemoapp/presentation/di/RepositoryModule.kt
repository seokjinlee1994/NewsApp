package com.lsj.newsdemoapp.presentation.di

import com.lsj.newsdemoapp.data.repository.NewsRepositoryImpl
import com.lsj.newsdemoapp.data.repository.dataSource.NewsLocalDataSource
import com.lsj.newsdemoapp.data.repository.dataSource.NewsRemoteDataSource
import com.lsj.newsdemoapp.domain.repository.NewsRepository
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
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }
}