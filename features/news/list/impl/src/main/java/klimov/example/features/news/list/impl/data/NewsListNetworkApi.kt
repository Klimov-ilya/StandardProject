package klimov.example.features.news.list.impl.data

import klimov.example.sdk.services.network.NetworkException
import kotlin.jvm.Throws

internal class NewsListNetworkApi(
    private val newsListApi: NewsListApi
) {

    @Throws(NetworkException::class)
    suspend fun getNewsList(): List<String> {
        return newsListApi.getNewsList()
    }
}