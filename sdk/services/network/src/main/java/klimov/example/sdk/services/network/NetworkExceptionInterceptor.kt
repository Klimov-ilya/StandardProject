package klimov.example.sdk.services.network

import okhttp3.Interceptor
import okhttp3.Response

internal class NetworkExceptionInterceptor : Interceptor {

    @Throws(NetworkException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val responseResult = runCatching { chain.proceed(request) }

        val response = responseResult.getOrElse {
            throw NetworkException.NetworkIOException(
                message = responseResult.exceptionOrNull()?.message,
                cause = responseResult.exceptionOrNull()
            )
        }

        return when  {
            response.isSuccessful && response.body != null -> response
            response.isSuccessful && response.body == null -> throw NetworkException.NetworkIOException.NetworkEmptyBodyException()
            else -> throw NetworkException.NetworkHttpException(response)
        }
    }
}