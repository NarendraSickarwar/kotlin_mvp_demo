package com.app.horizentallistview.data.di.builder


import com.app.horizentallistview.ui.main.MainActivityModule
import com.app.horizentallistview.ui.mainactivity.view.MainActivity
import com.app.horizentallistview.ui.splash.SplashActivityModule
import com.app.horizentallistview.ui.splash.view.SplashMVPActivity



import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Narendra Singh on 12/6/2019.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashMVPActivity

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity



}