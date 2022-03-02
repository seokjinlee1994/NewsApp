package com.lsj.newsdemoapp.domain.usecase

import com.lsj.newsdemoapp.data.model.Article
import com.lsj.newsdemoapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute() : Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}