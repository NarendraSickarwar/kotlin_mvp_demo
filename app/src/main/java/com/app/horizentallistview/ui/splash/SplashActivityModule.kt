package com.app.horizentallistview.ui.splash

import com.app.horizentallistview.ui.splash.interactor.SplashInteractor
import com.app.horizentallistview.ui.splash.presenter.SplashMVPPresenter
import com.app.horizentallistview.ui.splash.presenter.SplashPresenter
import com.mindorks.framework.mvp.ui.splash.interactor.SplashMVPInteractor
import com.mindorks.framework.mvp.ui.splash.view.SplashMVPView

import dagger.Module
import dagger.Provides

/**
 * Created by Narendra Singh on 12/6/2019.
 */

@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashInteractor(splashInteractor: SplashInteractor): SplashMVPInteractor = splashInteractor

    @Provides
    internal fun provideSplashPresenter(splashPresenter: SplashPresenter<SplashMVPView, SplashMVPInteractor>)
            : SplashMVPPresenter<SplashMVPView, SplashMVPInteractor> = splashPresenter
}