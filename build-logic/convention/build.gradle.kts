import org.gradle.kotlin.dsl.`kotlin-dsl`
import java.util.Properties

plugins {
    `kotlin-dsl`
}

val jvmVersion = Properties().run {
    rootProject.file("../gradle.properties").inputStream().use(::load)
    getProperty("project.jvm.version").toInt()
}

kotlin {
    jvmToolchain(jvmVersion)
}

dependencies {
    implementation(libs.android.plugin)
    implementation(libs.kotlin.plugin)
}

gradlePlugin {
    plugins {
        register("customApplicationPlugin") {
            id = libs.plugins.standard.application.get().pluginId
            implementationClass = "ApplicationPlugin"
        }
        register("customLibraryPlugin") {
            id = libs.plugins.standard.library.get().pluginId
            implementationClass = "LibraryPlugin"
        }
    }
}
