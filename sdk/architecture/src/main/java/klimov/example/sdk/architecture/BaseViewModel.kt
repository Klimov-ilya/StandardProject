package klimov.example.sdk.architecture

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<ViewState, ViewCommand> : ViewModel() {
   private val _viewState: MutableStateFlow<ViewState> by lazy {
       MutableStateFlow(getInitialViewState())
    }
    val viewState: StateFlow<ViewState>
        get() = _viewState.asStateFlow()

    protected abstract val initialViewState: ViewState

    protected abstract fun getInitialViewState(): ViewState

    protected fun mutateViewState(mutation: (ViewState) -> ViewState) {
        _viewState.value = mutation(_viewState.value)
    }
}