package com.app.horizentallistview

import android.app.Activity
import android.app.Application
import com.app.horizentallistview.data.di.component.DaggerAppComponent
import com.app.horizentallistview.data.util.AppLogger
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Narendra Singh on 12/5/2019.
 */
class MyApp : Application(), HasActivityInjector {

    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        AppLogger.init()
    }


}