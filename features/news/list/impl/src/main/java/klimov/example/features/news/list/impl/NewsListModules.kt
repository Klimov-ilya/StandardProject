package klimov.example.features.news.list.impl

import klimov.example.features.news.list.impl.data.NewsListApi
import klimov.example.features.news.list.impl.data.NewsListNetworkApi
import klimov.example.features.news.list.impl.data.NewsListRepository
import klimov.example.features.news.list.impl.ui.NewsListViewModel
import klimov.example.sdk.services.network.retrofit.RetrofitFactory
import klimov.example.sdk.services.network.retrofit.RetrofitConfig
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel
import retrofit2.Retrofit

val newsListModules = module {
    single<Retrofit> {
        get<RetrofitFactory>().create(config = RetrofitConfig.DEFAULT)
    }
    single<NewsListApi> { get<Retrofit>().create(NewsListApi::class.java) }
    single<NewsListNetworkApi>()
    single<NewsListRepository>()
    viewModel<NewsListViewModel>()
}
