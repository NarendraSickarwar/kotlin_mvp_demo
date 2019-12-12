package com.app.horizentallistview.ui.base.interactor

import com.app.horizentallistview.data.data.preferences.PreferenceHelper
import com.app.horizentallistview.data.network.ApiHelper


/**
 * Created by Narendra Singh on 12/6/2019.
 */

open class BaseInteractor() : MVPInteractor {

    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }



}