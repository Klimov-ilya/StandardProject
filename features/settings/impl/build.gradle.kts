plugins {
    alias(libs.plugins.standard.library)
}

android {
    namespace = "klimov.example.features.settings.impl"
}

dependencies {
    implementation(project(":features:settings:api"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}