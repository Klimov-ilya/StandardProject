package klimov.example.sdk.services.network

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class NetworkExceptionTests {
    @Test
    fun `test NetworkEmptyBodyException`() {
        val exception = NetworkException.NetworkIOException.NetworkEmptyBodyException()
        assert(exception.message == "Request is successful, but the response body is null")
    }

    @Test
    fun `test NetworkIOException`() {
        val exception = NetworkException.NetworkIOException("Network error", Throwable("Cause"))
        assert(exception.message == "Network error")
        assert(exception.cause?.message == "Cause")
    }

    @Test
    fun `test NetworkHttpException`() {
        val exception = NetworkException.NetworkHttpException(
            okhttp3.Response.Builder()
                .request(okhttp3.Request.Builder().url("https://example.com").build())
                .protocol(okhttp3.Protocol.HTTP_1_1)
                .code(404)
                .message("Not Found")
                .body(okhttp3.ResponseBody.create(null, "Error body"))
                .build()
        )

        assert(exception.url.toString() == "https://example.com/")
        assert(String(exception.errorBody) == "Error body")
        assert(exception.message == "HTTP 404: https://example.com/ returned Error body")
    }
}
