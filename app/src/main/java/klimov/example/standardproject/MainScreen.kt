package klimov.example.standardproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import klimov.example.features.news.list.api.NewsListRoute
import klimov.example.features.news.list.impl.featureNewsListEntryBuilder
import klimov.example.features.settings.api.SettingsRoute
import klimov.example.features.settings.impl.featureSettingsEntryBuilder
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
                featureNewsListEntryBuilder(
                    onNavigate = { route -> backStack.add(route) },
                )
                featureSettingsEntryBuilder(
                    onNavigate = { route -> backStack.add(route) },
                )
            },
        )
    }
}

@Composable
private fun MainNavigationBar(
    selectedRoute: SectionRoute,
    onRouteSelected: (SectionRoute) -> Unit,
) {
    NavigationBar {
        NavigationBarItem(
            selected = selectedRoute == NewsListRoute,
            onClick = { onRouteSelected(NewsListRoute) },
            icon = { Text(text = "1") },
            label = { Text(text = "Стрим") },
        )
        NavigationBarItem(
            selected = selectedRoute == SettingsRoute,
            onClick = { onRouteSelected(SettingsRoute) },
            icon = { Text(text = "⚙") },
            label = { Text(text = "Настройки") },
        )
    }
}
