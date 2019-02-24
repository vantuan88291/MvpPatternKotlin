package com.tuan88291.mvppatternkotlin

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.google.gson.Gson

class App : MultiDexApplication() {
    var gSon: Gson? = null
        private set

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        instance = this
        gSon = Gson()
    }

    companion object {
        var instance: App? = null
            private set
    }
}

