package com.app.horizentallistview.ui.base.presenter

import com.app.horizentallistview.ui.base.interactor.MVPInteractor
import com.app.horizentallistview.ui.base.view.MVPView


/**
 * Created by Narendra Singh on 12/6/2019.
 */

interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}