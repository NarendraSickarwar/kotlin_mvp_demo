package com.app.horizentallistview.ui.mainactivity.view

import com.app.horizentallistview.data.data.database.repository.songs.Song
import com.app.horizentallistview.ui.base.view.MVPView
import com.app.horizentallistview.ui.main.interactor.SongsData


/**
 * Created by Narendra Singh on 12/6/2019.
 */

interface MainMVPView : MVPView {


    fun displaySongsData(songs: List<Song>)

    fun displayArtistSongsData(songs: List<SongsData>)

    fun displayAlbumSongsData(songs: List<SongsData>)

}