package com.app.horizentallistview.ui.main.interactor


import com.app.horizentallistview.data.data.database.repository.songs.Song
import com.app.horizentallistview.data.data.database.repository.songs.SongRepo
import com.app.horizentallistview.data.data.preferences.PreferenceHelper
import com.app.horizentallistview.data.network.ApiHelper
import com.app.horizentallistview.data.network.SongResponse
import com.app.horizentallistview.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Narendra Singh on 12/6/2019.
 */

class MainInteractor @Inject internal constructor(
    private val songRepoHelper: SongRepo,
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper = preferenceHelper, apiHelper = apiHelper), MainMVPInteractor {

    override fun getSongsData() = songRepoHelper.loadSongs()


    override fun makeSongApiCall(): Observable<SongResponse> {
        return apiHelper.getSongApiCall()
    }

    override fun saveSongApiCall(songResponse: SongResponse): Observable<Boolean> {

        return songRepoHelper.isSongsRepoEmpty().concatMap { isEmpty ->
            if (isEmpty) {
                songRepoHelper.insertSongs(songResponse.data)
            } else
                Observable.just(false)
        }
    }

    override fun getAlbumSongsData() = songRepoHelper.loadSongs()
        .flatMapIterable { song -> song }
        .flatMapSingle { song -> getAlbumSongs(song) }
        .toList()
    private fun getAlbumSongs(song: Song) =
        songRepoHelper.loadSongBYAlbum(song.albumText)
        .map { songs -> createAlbumSong(songs, song) }


    private fun createAlbumSong(songs: List<Song>, song: Song) = SongsData(songs, song)

    override fun getArtistSongsData() = songRepoHelper.loadSongs()
        .flatMapIterable { song -> song }
        .flatMapSingle { song -> getArtistSongs(song) }
        .toList()
    private fun getArtistSongs(song: Song) =
        songRepoHelper.loadSongBYArtist(song.artistText)
            .map { songs -> createArtistSong(songs, song) }


    private fun createArtistSong(songs: List<Song>, song: Song) = SongsData(songs, song)
}




