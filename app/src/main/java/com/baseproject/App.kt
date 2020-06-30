package com.baseproject

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {

        private lateinit var context: Context

        fun applicationContext(): Context {
            return context
        }

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}