package klimov.example.features.news.list.impl.ui

import androidx.lifecycle.viewModelScope
import klimov.example.features.news.list.impl.data.NewsListRepository
import klimov.example.sdk.architecture.BaseViewModel
import kotlinx.coroutines.launch

internal class NewsListViewModel(
    private val repository: NewsListRepository
) : BaseViewModel<NewsListState, Nothing>() {
    override val initialViewState: NewsListState get() = NewsListState.Loading

    init {
        initialLoading()
    }

    fun onUiEvent(event: NewsListUiEvent) {
        when (event) {
            is NewsListUiEvent.OnRefresh -> {
                mutateContent { it.copy(isRefreshing = true) }
                loadNewsList()
            }
            is NewsListUiEvent.OnRetry -> initialLoading()
        }
    }

    private fun initialLoading() {
        mutateViewState { NewsListState.Loading }
        loadNewsList()
    }

    private fun loadNewsList() {
        viewModelScope.launch {
            val result = repository.getNewsList()
            result
                .onSuccess { newsList -> mutateViewState { NewsListState.Content(newsList = newsList) } }
                .onFailure { _ -> mutateViewState { NewsListState.LoadingError } }

            mutateContent { it.copy(isRefreshing = false)}
        }
    }

    private fun mutateContent(mutation: (NewsListState.Content) -> NewsListState.Content) {
        mutateViewState { state ->
            when (state) {
                is NewsListState.Content -> mutation(state)
                else -> state
            }
        }
    }
}