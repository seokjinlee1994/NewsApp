package com.lsj.newsdemoapp.data.repository

import com.lsj.newsdemoapp.data.model.APIResponse
import com.lsj.newsdemoapp.data.model.Article
import com.lsj.newsdemoapp.data.repository.dataSource.NewsLocalDataSource
import com.lsj.newsdemoapp.data.repository.dataSource.NewsRemoteDataSource
import com.lsj.newsdemoapp.data.util.Resource
import com.lsj.newsdemoapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {
    override suspend fun getNewsHeadlines(country : String, page : Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }

    override suspend fun getSearchedNews(country: String, searchQuery: String, page: Int): Resource<APIResponse> {
        return responseToResource(
            newsRemoteDataSource.getSearchedNews(country, searchQuery, page)
        )
    }

    private fun responseToResource(response : Response<APIResponse>) : Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticlesFromDB(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedArticles()
    }
}