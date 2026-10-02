package klimov.example.features.news.list.impl.ui

import klimov.example.sdk.architecture.BaseViewModel

internal class NewsListViewModel : BaseViewModel<NewsListState, Nothing>() {
    override val initialViewState: NewsListState get() = NewsListState()

    fun getText() = "Hello world"
}