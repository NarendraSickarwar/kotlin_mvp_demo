package com.app.horizentallistview.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.app.horizentallistview.data.util.CommonUtil

import dagger.android.AndroidInjection

/**
 * Created by Narendra Singh on 12/6/2019.
 */

abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
        setUp()
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    private fun performDI() = AndroidInjection.inject(this)
    abstract fun setUp()
}