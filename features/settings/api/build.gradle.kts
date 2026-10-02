plugins {
    alias(libs.plugins.standard.library)
}

android {
    namespace = "klimov.example.features.settings.api"
}

dependencies {
    implementation(project(":sdk:navigation"))
}