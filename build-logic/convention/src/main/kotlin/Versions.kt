import org.gradle.api.Project

object Versions {
    object AndroidConfig {
        const val compileSdk = 37
        const val targetSdk = 37
        const val minSdk = 26
    }

    fun jvmVersion(project: Project): Int =
        project.providers.gradleProperty("project.jvm.version").get().toInt()
}