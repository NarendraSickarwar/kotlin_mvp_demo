package com.mindorks.framework.mvp.ui.splash.interactor

import com.app.horizentallistview.data.data.database.repository.songs.Song
import com.app.horizentallistview.ui.base.interactor.MVPInteractor

import io.reactivex.Observable

/**
 * Created by Narendra Singh on 12/6/2019.
 */

interface SplashMVPInteractor : MVPInteractor {


    fun getSong() : Observable<List<Song>>
}