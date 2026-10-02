package klimov.example.standardproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import klimov.example.features.news.list.api.NewsListRoute
import klimov.example.sdk.navigation.SectionRoute

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val backStack = remember { mutableStateListOf<NavKey>(NewsListRoute) }
    val currentRoute = backStack.last()
    val currentSection = backStack.filterIsInstance<SectionRoute>().last()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (currentRoute is SectionRoute) {
                MainNavigationBar(
                    selectedRoute = currentSection,
                    onRouteSelected = { route ->
                        backStack.clear()
                        backStack.add(route)
                    },
                )
            }
        }
    ) { innerPadding ->
        NavDisplay(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
            ),
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                featureStreamEntryBuilder(
                    onNavigate = { route -> backStack.add(route) },
                )
                featureSettingsEntryBuilder(
                    onNavigate = { route -> backStack.add(route) },
                )
            },
        )
    }
}