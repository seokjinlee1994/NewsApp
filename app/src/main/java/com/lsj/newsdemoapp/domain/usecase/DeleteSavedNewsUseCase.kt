package com.lsj.newsdemoapp.domain.usecase

import com.lsj.newsdemoapp.data.model.Article
import com.lsj.newsdemoapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}