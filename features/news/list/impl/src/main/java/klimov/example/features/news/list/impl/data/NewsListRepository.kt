package klimov.example.features.news.list.impl.data

import klimov.example.sdk.utils.coroutines.runCatchingCancellable

internal class NewsListRepository(
    private val networkApi: NewsListNetworkApi
) {
    suspend fun getNewsList(): Result<List<String>> = runCatchingCancellable { networkApi.getNewsList() }
}