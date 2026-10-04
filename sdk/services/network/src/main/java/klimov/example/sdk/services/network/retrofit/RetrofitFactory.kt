package klimov.example.sdk.services.network.retrofit

import klimov.example.sdk.services.network.NetworkExceptionInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class RetrofitFactory {
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(NetworkExceptionInterceptor())
            .build()
    }

    fun create(config: RetrofitConfig): Retrofit = Retrofit.Builder()
        .baseUrl(config.baseUrl)
        .client(okHttpClient)
        .addConverterFactory(config.converterFactory)
        .build()
}