package com.lsj.newsdemoapp.presentation.di

import com.lsj.newsdemoapp.data.model.db.ArticleDAO
import com.lsj.newsdemoapp.data.repository.dataSource.NewsLocalDataSource
import com.lsj.newsdemoapp.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
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
    fun provideLocalDataSource(articleDAO: ArticleDAO) : NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDAO)
    }
}