package com.mindorks.framework.mvp.data.database


import androidx.room.Database
import androidx.room.RoomDatabase

import com.app.horizentallistview.data.data.database.repository.songs.Song
import com.app.horizentallistview.data.data.database.repository.songs.SongsDao


/**
 * Created by Narendra Singh on 12/6/2019.
 */

@Database(entities = [(Song::class)], version = 2)
abstract class AppDatabase : RoomDatabase() {



    abstract fun songsDao(): SongsDao

}