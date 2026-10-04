package klimov.example.standardproject

import android.app.Application
import klimov.example.features.news.list.impl.newsListModules
import klimov.example.sdk.services.network.networkModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class StandardProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@StandardProjectApplication)
            modules(
                listOf(
                    newsListModules,
                    networkModules
                )
            )
        }
    }
}