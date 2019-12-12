package com.app.horizentallistview.ui.splash.presenter

import com.app.horizentallistview.ui.base.presenter.MVPPresenter

import com.mindorks.framework.mvp.ui.splash.interactor.SplashMVPInteractor
import com.mindorks.framework.mvp.ui.splash.view.SplashMVPView

/**
 * Created by Narendra Singh on 12/6/2019.
 */

interface SplashMVPPresenter<V : SplashMVPView, I : SplashMVPInteractor> : MVPPresenter<V, I>