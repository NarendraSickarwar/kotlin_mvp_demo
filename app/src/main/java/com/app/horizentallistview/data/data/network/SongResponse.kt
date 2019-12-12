package com.app.horizentallistview.data.network


import com.app.horizentallistview.data.data.database.repository.songs.Song
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Narendra Singh on 12/6/2019.
 */

data class SongResponse  (
    @Expose
    @SerializedName("data")
    var data: List<Song>? = null


)


