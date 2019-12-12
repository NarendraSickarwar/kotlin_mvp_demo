package com.app.horizentallistview.data.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.app.horizentallistview.data.data.database.repository.songs.SongRepo
import com.app.horizentallistview.data.data.database.repository.songs.SongRepository
import com.app.horizentallistview.data.data.preferences.AppPreferenceHelper
import com.app.horizentallistview.data.data.preferences.PreferenceHelper
import com.app.horizentallistview.data.di.PreferenceInfo
import com.app.horizentallistview.data.network.ApiHelper
import com.app.horizentallistview.data.network.AppApiHelper
import com.app.horizentallistview.data.util.AppConstants
import com.app.horizentallistview.data.util.SchedulerProvider
import com.mindorks.framework.mvp.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Narendra Singh on 12/6/2019.
 */

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()



    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper



    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun provideQuestionRepoHelper(appDatabase: AppDatabase): SongRepo = SongRepository(appDatabase.songsDao())



    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()


}