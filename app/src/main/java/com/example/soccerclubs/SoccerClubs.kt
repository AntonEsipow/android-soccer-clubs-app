package com.example.soccerclubs

import android.app.Application

class SoccerClubs: Application() {

    companion object{
        lateinit var application: SoccerClubs
    }

    override fun onCreate() {
        super.onCreate()

        application = this

        SharedPrefUtil.init(this)
    }

}