package app.misaghpour.news

import android.app.Application
import app.misaghpour.news.data.AppContainer
import app.misaghpour.news.data.DefaultAppContainer

class NewsApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}