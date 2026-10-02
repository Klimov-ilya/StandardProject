package klimov.example.features.news.list.impl.ui

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun NewsListScreen(
    viewModel: NewsListViewModel = koinViewModel()
) {
    Text(viewModel.getText())
}