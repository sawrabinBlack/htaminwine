package com.softedify.htaminwine

import android.app.Application
import com.softedify.htaminwine.data.models.HtaminWineModelImpl


class HtaminWineApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        HtaminWineModelImpl.initDatabase(applicationContext)
    }
}