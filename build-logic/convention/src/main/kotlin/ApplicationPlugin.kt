import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class ApplicationPlugin : CommonPlugin<ApplicationExtension>(
    ApplicationExtension::class.java
) {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.application")
        super.apply(target)
        target.extensions.configure<ApplicationExtension> {
            defaultConfig {
                minSdk = Versions.AndroidConfig.minSdk
                targetSdk = Versions.AndroidConfig.targetSdk
            }
            compileOptions {
                sourceCompatibility = JavaVersion.toVersion(Versions.jvmVersion(target))
                targetCompatibility = JavaVersion.toVersion(Versions.jvmVersion(target))
            }
        }
    }
}