plugins {
    alias(libs.plugins.standard.library)
}

android {
    namespace = "klimov.example.sdk.utils"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}