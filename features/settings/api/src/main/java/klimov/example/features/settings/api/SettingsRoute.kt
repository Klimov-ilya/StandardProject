package klimov.example.features.settings.api

import androidx.navigation3.runtime.NavKey
import klimov.example.sdk.navigation.SectionRoute
import kotlinx.serialization.Serializable

@Serializable
data object SettingsRoute : SectionRoute

@Serializable
data object SettingsDetailsRoute : NavKey