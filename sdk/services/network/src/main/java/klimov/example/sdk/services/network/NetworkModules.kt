package klimov.example.sdk.services.network

import klimov.example.sdk.services.network.retrofit.RetrofitFactory
import org.koin.dsl.module

val networkModules = module {
    single { RetrofitFactory() }
}
