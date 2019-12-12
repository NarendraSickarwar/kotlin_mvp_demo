package com.app.horizentallistview.ui.main.presenter

import com.app.horizentallistview.data.network.SongResponse
import com.app.horizentallistview.ui.base.presenter.MVPPresenter
import com.app.horizentallistview.ui.main.interactor.MainMVPInteractor

import com.app.horizentallistview.ui.mainactivity.view.MainMVPView


/**
 * Created by Narendra Singh on 12/6/2019.
 */

interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {

    fun refreshSongsData(): Boolean?
    fun onViewPrepared()

    fun getArtistSongsData(): Boolean?
    fun getAlbumSongsData(): Boolean?
    fun saveSongDatabase(songResponse: SongResponse)

    fun onGetDataOnAlbum()
}