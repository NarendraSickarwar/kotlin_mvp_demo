package com.mindorks.framework.mvp.ui.splash.view

import com.app.horizentallistview.ui.base.view.MVPView


/**
 * Created by Narendra Singh on 12/6/2019.
 */

interface SplashMVPView : MVPView {

    fun showSuccessToast()
    fun showErrorToast()
    fun openMainActivity()
    fun openLoginActivity()
}