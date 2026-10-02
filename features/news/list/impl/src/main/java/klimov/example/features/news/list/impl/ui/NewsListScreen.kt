package klimov.example.features.news.list.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun NewsListScreen(
    viewModel: NewsListViewModel = koinViewModel()
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle(NewsListState.Loading)

    NewsListContent(
        state = state,
        onUiEvent = viewModel::onUiEvent
    )
}

@Composable
private fun NewsListContent(
    state: NewsListState,
    onUiEvent: (NewsListUiEvent) -> Unit
) {
    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            when (state) {
                is NewsListState.Loading -> NewsListLoadingState()
                is NewsListState.LoadingError -> NewsListErrorState(onUiEvent = onUiEvent)
                is NewsListState.Content -> {
                    Text(text = "News list: ${state.newsList.joinToString()}")
                }
            }
        }
    }
}

@Composable
private fun NewsListLoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun NewsListErrorState(
    onUiEvent: (NewsListUiEvent) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error loading news list")
        Button(onClick = { onUiEvent(NewsListUiEvent.OnRetry) }) {
            Text(text = "Retry")
        }
    }
}