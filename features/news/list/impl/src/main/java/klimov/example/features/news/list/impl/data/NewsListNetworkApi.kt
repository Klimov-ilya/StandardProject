package klimov.example.features.news.list.impl.data

import klimov.example.sdk.services.network.NetworkException
import kotlin.jvm.Throws

internal class NewsListNetworkApi(
    private val newsListApi: NewsListApi
) {

    @Throws(NetworkException::class)
    suspend fun getNewsList(): List<String> {
        return newsListApi.getNewsList(limit = NEWS_LIST_LIMIT)
            .results
            .map(NewsArticleResponse::title)
    }

    private companion object {
        const val NEWS_LIST_LIMIT = 10
    }
}
