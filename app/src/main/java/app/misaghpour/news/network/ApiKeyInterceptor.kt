package app.misaghpour.news.network

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url.newBuilder()
            .addQueryParameter("apiKey", apiKey)
            .build()
        val requestBuilder = originalRequest.newBuilder()
            .url(url)

        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }
}