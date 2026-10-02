import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal open class CommonPlugin<T : CommonExtension>(
    private val extensionClass: Class<T>
) : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure(extensionClass) {
                configureAndroid(this)
            }

            val jvmVersion = Versions.jvmVersion(this)
            extensions.configure<KotlinAndroidProjectExtension> {
                jvmToolchain(jvmVersion)
                compilerOptions {
                    jvmTarget.set(JvmTarget.fromTarget(jvmVersion.toString()))
                }
            }
        }
    }

    private fun configureAndroid(extension: CommonExtension) {
        extension.apply {
            compileSdk = Versions.AndroidConfig.compileSdk
        }
    }
}