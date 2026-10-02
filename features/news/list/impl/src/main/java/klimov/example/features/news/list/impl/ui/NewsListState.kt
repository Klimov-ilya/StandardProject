package klimov.example.features.news.list.impl.ui

internal data class NewsListState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val newsItems: List<String> = emptyList(),
)