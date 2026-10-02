package klimov.example.sdk.architecture

import org.junit.Assert.assertEquals
import org.junit.Test

class BaseViewModelTest {
    @Test
    fun viewStateStartsWithInitialState() {
        val viewModel = TestViewModel()

        assertEquals(0, viewModel.viewState.value)
    }

    @Test
    fun mutateViewStateUpdatesCurrentState() {
        val viewModel = TestViewModel()

        viewModel.increment()

        assertEquals(1, viewModel.viewState.value)
    }

    private class TestViewModel : BaseViewModel<Int, Nothing>() {
        override val initialViewState: Int = 0

        fun increment() {
            mutateViewState { currentState -> currentState + 1 }
        }
    }
}
