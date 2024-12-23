package com.example.videocallingapp.di

import com.example.videocallingapp.VideoCallingApp
import com.example.videocallingapp.connect.connectViewModel
import com.example.videocallingapp.video.VideoCallViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    factory {
        val app = androidContext().applicationContext as VideoCallingApp
        app.client
    }
    viewModelOf(::connectViewModel)
    viewModelOf(::VideoCallViewModel)
}