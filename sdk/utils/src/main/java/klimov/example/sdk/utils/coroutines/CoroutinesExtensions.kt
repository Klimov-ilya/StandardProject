package klimov.example.sdk.utils.coroutines

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive

suspend inline fun <R> runCatchingCancellable(block: () -> R): Result<R> {
    currentCoroutineContext().ensureActive()

    return try {
        val value = block()
        currentCoroutineContext().ensureActive()
        Result.success(value)
    } catch (exception: CancellationException) {
        throw exception
    } catch (exception: Throwable) {
        Result.failure(exception)
    }
}