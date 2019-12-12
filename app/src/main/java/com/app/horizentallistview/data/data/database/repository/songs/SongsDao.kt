package com.app.horizentallistview.data.data.database.repository.songs


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Narendra Singh on 12/6/2019.
 */

@Dao
interface SongsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(song: List<Song>?)

    @Query("SELECT * FROM songs group BY artist")
    fun loadAll(): List<Song>

    @Query("SELECT * FROM songs group BY album")
    fun loadAlbumAll(): List<Song>

    @Query("SELECT * FROM songs WHERE album = :album")
    fun loadSongsByAlbum(album: String): List<Song>

    @Query("SELECT * FROM songs WHERE artist = :artist")
    fun loadSongsByArtist(artist: String): List<Song>
}