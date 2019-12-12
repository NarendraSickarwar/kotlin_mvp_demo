package com.app.horizentallistview.data.data.database.repository.songs

import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Narendra Singh on 12/6/2019.
 */

interface SongRepo {

    fun isSongsRepoEmpty(): Observable<Boolean>

    fun insertSongs(songs: List<Song>?): Observable<Boolean>

    fun loadSongs(): Observable<List<Song>>

    fun loadSongBYArtist(artist: String): Single<List<Song>>

    fun loadSongBYAlbum(album: String): Single<List<Song>>
}