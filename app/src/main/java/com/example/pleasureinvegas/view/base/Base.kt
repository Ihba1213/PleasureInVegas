package com.example.pleasureinvegas.view.base

import android.app.Application
import android.content.Context

class Base : Application() {

    override fun onCreate() {
        instance = this
        super.onCreate()

    }

    companion object {
        var instance: Base? = null
            private set

        @JvmStatic
        val context: Context?
            get() = instance
    }

}

