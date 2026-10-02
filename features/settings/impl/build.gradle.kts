plugins {
    alias(libs.plugins.standard.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "klimov.example.features.settings.impl"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":features:settings:api"))
    implementation(project(":sdk:navigation"))
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
