package klimov.example.sdk.services.network

import androidx.core.net.toUri
import okhttp3.HttpUrl
import okhttp3.Response
import java.io.IOException

sealed class NetworkException(
    override val message: String?,
) : IOException(message) {
    open class NetworkIOException(
        override val message: String?,
        override val cause: Throwable? = null,
    ) : NetworkException(message) {
        override fun toString(): String  = "$message, $cause"

        class NetworkEmptyBodyException(
            override val message: String? = "Request is successful, but the response body is null",
        ) : NetworkIOException(message)
    }

    class NetworkHttpException(
        private val response: Response
    ) : NetworkException("HTTP ${response.code}") {
        private val cachedBodyBytes: ByteArray = runCatching {
            response.body?.bytes()
        }.getOrNull() ?: byteArrayOf()

        val url: HttpUrl get() = response.request.url
        val errorBody: ByteArray get() = cachedBodyBytes

        override val message: String by lazy { createDetailedMessage() }

        private fun createDetailedMessage(): String {
            val url = url.toString()
            val cleanUrl = url.toUri().buildUpon().clearQuery().build().toString()
            val body = String(errorBody)

            return "${super.message}: $cleanUrl returned $body"
        }
    }
}