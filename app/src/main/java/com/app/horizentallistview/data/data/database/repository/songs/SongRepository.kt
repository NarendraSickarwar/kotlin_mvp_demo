package com.app.horizentallistview.data.data.database.repository.songs

import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Narendra Singh on 12/6/2019.
 */

class SongRepository @Inject internal constructor(private val songsDao: SongsDao) : SongRepo {

    override fun isSongsRepoEmpty(): Observable<Boolean> = Observable.fromCallable({ songsDao.loadAll().isEmpty() })

    override fun insertSongs(songs: List<Song>?): Observable<Boolean> {
        songsDao.insertAll(songs)
        return Observable.just(true)
    }

    override fun loadSongs(): Observable<List<Song>> {

        return Observable.fromCallable( {songsDao.loadAll()})
    }

    override fun loadSongBYArtist(artist: String): Single<List<Song>> {
        return  Single.fromCallable({ songsDao.loadSongsByArtist(artist) })
    }

    override fun loadSongBYAlbum(album: String): Single<List<Song>> {
        return  Single.fromCallable({ songsDao.loadSongsByAlbum(album) })
    }
}


