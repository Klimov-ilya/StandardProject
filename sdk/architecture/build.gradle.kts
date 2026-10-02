plugins {
    alias(libs.plugins.standard.library)
}

android {
    namespace = "klimov.example.sdk.architecture"
}

dependencies {
    api(libs.androidx.appcompat)
    api(libs.androidx.core.ktx)

    testImplementation(libs.junit)
}
