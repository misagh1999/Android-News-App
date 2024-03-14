package app.misaghpour.news.data

import app.misaghpour.news.model.ApiResponse
import app.misaghpour.news.network.NewsApiService

interface NewsRepository {
    suspend fun getTopHeadlines(): ApiResponse
}

class NetworkNewsRepository(
    private val newsApiService: NewsApiService
) : NewsRepository {
    override suspend fun getTopHeadlines(): ApiResponse =
        newsApiService.getTopHeadlines("us")

}