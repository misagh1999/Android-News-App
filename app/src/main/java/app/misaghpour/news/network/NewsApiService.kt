package app.misaghpour.news.network

import app.misaghpour.news.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String): ApiResponse
}