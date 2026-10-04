package klimov.example.features.news.list.impl.data

import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsListApi {
    @GET("articles/")
    suspend fun getNewsList(@Query("limit") limit: Int): NewsListResponse
}

@Serializable
internal data class NewsListResponse(
    val results: List<NewsArticleResponse>,
)

@Serializable
internal data class NewsArticleResponse(
    val title: String,
)
