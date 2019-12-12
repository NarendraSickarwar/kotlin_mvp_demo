package com.app.horizentallistview.data.di.component

import android.app.Application
import com.app.horizentallistview.MyApp
import com.app.horizentallistview.data.di.builder.ActivityBuilder
import com.app.horizentallistview.data.di.module.AppModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Narendra Singh on 12/6/2019.
 */

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApp)

}

