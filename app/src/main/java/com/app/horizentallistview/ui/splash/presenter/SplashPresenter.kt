package com.app.horizentallistview.ui.splash.presenter


import com.app.horizentallistview.data.util.SchedulerProvider
import com.app.horizentallistview.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.splash.interactor.SplashMVPInteractor
import com.mindorks.framework.mvp.ui.splash.view.SplashMVPView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Narendra Singh on 12/6/2019.
 */

class SplashPresenter<V : SplashMVPView, I : SplashMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
    SplashMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        feedInDatabase()
    }

    private fun feedInDatabase() = interactor?.let {

                getView()?.let { decideActivityToOpen() }

    }

    private fun decideActivityToOpen() = getView()?.let {
       // if (isUserLoggedIn())
            it.openMainActivity()
       // else
          //  it.openLoginActivity()
    }




    private fun isUserLoggedIn(): Boolean {

        return false
    }

}