plugins {
    alias(libs.plugins.standard.library)
    alias(libs.plugins.koin.compiler)
}

android {
    namespace = "klimov.example.sdk.services.network"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    api(libs.squareup.retrofit2)
    testImplementation(libs.junit)
    testImplementation(libs.robolectric)
    androidTestImplementation(libs.androidx.junit)
}
