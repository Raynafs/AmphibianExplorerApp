package com.example.amphibiansapp

import android.app.Application
import com.example.amphibiansapp.network.AppContainer
import com.example.amphibiansapp.network.DefaultAppContainer

class AmphibiansApplication: Application() {

    lateinit var container : AppContainer

    override fun onCreate(){

        super.onCreate()
        container = DefaultAppContainer()

    }

}