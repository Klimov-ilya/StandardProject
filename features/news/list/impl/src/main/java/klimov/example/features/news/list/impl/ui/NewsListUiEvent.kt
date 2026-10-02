package klimov.example.features.news.list.impl.ui

internal sealed class NewsListUiEvent {
    data object OnRefresh : NewsListUiEvent()
    data object OnRetry : NewsListUiEvent()
}