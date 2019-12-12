package com.app.horizentallistview.ui.splash.view

import android.content.Intent
import android.os.Bundle
import com.app.horizentallistview.R
import com.app.horizentallistview.ui.base.view.BaseActivity
import com.app.horizentallistview.ui.mainactivity.view.MainActivity
import com.app.horizentallistview.ui.splash.presenter.SplashMVPPresenter

import com.mindorks.framework.mvp.ui.splash.interactor.SplashMVPInteractor

import com.mindorks.framework.mvp.ui.splash.view.SplashMVPView
import javax.inject.Inject
/**
 * Created by Narendra Singh on 12/6/2019.
 */

class SplashMVPActivity : BaseActivity(), SplashMVPView {

    @Inject
    lateinit var presenter: SplashMVPPresenter<SplashMVPView, SplashMVPInteractor>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.onAttach(this)
    }

    override fun setUp() {

    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onFragmentAttached() {
    }

    override fun showSuccessToast() {
    }

    override fun showErrorToast() {
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openLoginActivity() {

    }
}
