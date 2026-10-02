plugins {
    alias(libs.plugins.standard.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.koin.compiler)
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
    implementation(project(":sdk:utils"))
    implementation(project(":sdk:navigation"))
    implementation(project(":sdk:architecture"))
    implementation(project(":sdk:services:network"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime)

    implementation(libs.koin.android)
    implementation(libs.koin.compose.viewmodel)
    implementation(libs.koin.core)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
