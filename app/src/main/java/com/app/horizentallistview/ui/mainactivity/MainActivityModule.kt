package com.app.horizentallistview.ui.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.app.horizentallistview.ui.main.interactor.MainInteractor
import com.app.horizentallistview.ui.main.interactor.MainMVPInteractor
import com.app.horizentallistview.ui.main.presenter.MainMVPPresenter
import com.app.horizentallistview.ui.main.presenter.MainPresenter
import com.app.horizentallistview.ui.mainactivity.view.MainActivity
import com.app.horizentallistview.ui.mainactivity.view.MainMVPView
import com.app.horizentallistview.ui.mainactivity.view.SongAdapter
import dagger.Module
import dagger.Provides
import java.util.*

/**
 * Created by Narendra Singh on 12/6/2019.
 */

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter

    @Provides
    internal fun provideSongAdapter(): SongAdapter = SongAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(activity : MainActivity): LinearLayoutManager = LinearLayoutManager(activity)

}