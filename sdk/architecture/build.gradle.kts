plugins {
    alias(libs.plugins.standard.library)
}

android {
    namespace = "klimov.example.sdk.architecture"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)

    testImplementation(libs.junit)
}
