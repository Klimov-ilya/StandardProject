package klimov.example.features.news.list.impl.data

import retrofit2.http.POST

internal interface NewsListApi {
    @POST("/")
    suspend fun getNewsList(): List<String>
}