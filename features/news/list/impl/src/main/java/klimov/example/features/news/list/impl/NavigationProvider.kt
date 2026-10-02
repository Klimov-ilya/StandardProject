package klimov.example.features.news.list.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import klimov.example.features.news.list.api.NewsListRoute
import klimov.example.features.news.list.impl.ui.NewsListScreen

fun EntryProviderScope<NavKey>.featureNewsListEntryBuilder(
    onNavigate: (NavKey) -> Unit,
) {
    entry<NewsListRoute> {
        NewsListScreen()
    }
}
