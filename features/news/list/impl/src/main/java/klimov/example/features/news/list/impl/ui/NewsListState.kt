package klimov.example.features.news.list.impl.ui

internal sealed class NewsListState {
    internal data object Loading : NewsListState()
    internal data object LoadingError : NewsListState()
    internal data class Content(
        val newsList: List<String> = emptyList(),
        val isRefreshing: Boolean = false
    ) : NewsListState()
}