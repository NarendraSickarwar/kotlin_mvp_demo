package com.app.horizentallistview.ui.base.presenter

import com.app.horizentallistview.data.util.SchedulerProvider
import com.app.horizentallistview.ui.base.interactor.MVPInteractor
import com.app.horizentallistview.ui.base.view.MVPView



import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Narendra Singh on 12/6/2019.
 */

abstract class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}