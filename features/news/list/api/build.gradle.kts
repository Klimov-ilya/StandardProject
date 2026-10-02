plugins {
    alias(libs.plugins.standard.library)
}

android {
    namespace = "klimov.example.features.news.list.api"
}

dependencies {
    implementation(project(":sdk:navigation"))
}