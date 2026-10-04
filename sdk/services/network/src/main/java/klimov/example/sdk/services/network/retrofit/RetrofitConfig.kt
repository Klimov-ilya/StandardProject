package klimov.example.sdk.services.network.retrofit

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.kotlinx.serialization.asConverterFactory

data class RetrofitConfig(
    val baseUrl: String,
    val converterFactory: retrofit2.Converter.Factory,
) {
    companion object {
        val DEFAULT = RetrofitConfig(
            baseUrl = "https://api.spaceflightnewsapi.net/v4/",
            converterFactory = Json { ignoreUnknownKeys = true }
                .asConverterFactory("application/json".toMediaType()),
        )
    }
}