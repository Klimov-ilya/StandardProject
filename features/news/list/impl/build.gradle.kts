plugins {
    alias(libs.plugins.standard.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "klimov.example.features.news.list.impl"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":features:news:list:api"))
    implementation(project(":sdk:navigation"))
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.runtime)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
