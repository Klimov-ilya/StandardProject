package klimov.example.features.settings.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import klimov.example.features.settings.api.SettingsRoute
import klimov.example.features.settings.impl.ui.SettingsScreen

fun EntryProviderScope<NavKey>.featureSettingsEntryBuilder(
    onNavigate: (NavKey) -> Unit,
) {
    entry<SettingsRoute> {
        SettingsScreen()
    }
}
