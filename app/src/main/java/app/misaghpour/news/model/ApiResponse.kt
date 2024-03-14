package app.misaghpour.news.model

data class ApiResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)