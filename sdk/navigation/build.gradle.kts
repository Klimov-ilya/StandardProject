plugins {
    alias(libs.plugins.standard.library)
    alias(libs.plugins.android.library)
}

android {
    namespace = "klimov.example.sdk.navigation"
}

dependencies {
    api(libs.androidx.navigation3.runtime)
}