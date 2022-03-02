package com.lsj.newsdemoapp.domain.usecase

import com.lsj.newsdemoapp.data.model.APIResponse
import com.lsj.newsdemoapp.data.util.Resource
import com.lsj.newsdemoapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, searchQuery: String, page: Int): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }
}