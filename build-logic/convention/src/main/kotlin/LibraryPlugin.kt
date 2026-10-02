import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class LibraryPlugin : CommonPlugin<LibraryExtension>(
    LibraryExtension::class.java
) {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.library")
        super.apply(target)
        target.extensions.configure<LibraryExtension> {
            defaultConfig {
                minSdk = Versions.AndroidConfig.minSdk
            }
            compileOptions {
                sourceCompatibility = JavaVersion.toVersion(Versions.jvmVersion(target))
                targetCompatibility = JavaVersion.toVersion(Versions.jvmVersion(target))
            }
        }
    }
}