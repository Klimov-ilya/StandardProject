package klimov.example.features.news.list.impl

import klimov.example.features.news.list.impl.ui.NewsListViewModel
import org.koin.dsl.module
import org.koin.plugin.module.dsl.viewModel

val newsListModules = module {
    viewModel<NewsListViewModel>()
}