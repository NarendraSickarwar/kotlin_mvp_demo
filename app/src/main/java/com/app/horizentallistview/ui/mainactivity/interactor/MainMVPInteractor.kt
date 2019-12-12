package com.app.horizentallistview.ui.main.interactor

import com.app.horizentallistview.data.data.database.repository.songs.Song
import com.app.horizentallistview.data.network.SongResponse
import com.app.horizentallistview.ui.base.interactor.MVPInteractor


import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Narendra Singh on 12/6/2019.
 */

interface MainMVPInteractor : MVPInteractor {

    fun getSongsData(): Observable<List<Song>>

    fun makeSongApiCall() : Observable<SongResponse>
    fun saveSongApiCall(songResponse: SongResponse) :Observable<Boolean>

    fun getArtistSongsData(): Single<List<SongsData>>

    fun getAlbumSongsData(): Single<List<SongsData>>
}