package com.app.horizentallistview.ui.mainactivity.view


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.horizentallistview.R
import com.app.horizentallistview.data.data.database.repository.songs.Song
import com.app.horizentallistview.ui.main.interactor.SongsData
import kotlinx.android.synthetic.main.item_song_list.view.*
import java.util.*


/**
 * Created by Narendra Singh on 12/6/2019.
 */

class SongAdapter(private val songListItems: MutableList<SongsData>) :
    RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    var activity: Activity? = null
    var difference: Int? = 0
    var countlistitem: Int = 1

    override fun getItemCount() = this.songListItems.size

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }
    internal fun addCountToList(song: List<SongsData>,countlistitem:Int){
        this.difference = countlistitem
        this.songListItems.addAll(song)
        notifyDataSetChanged()
    }

    internal fun addSongsToList(song: List<SongsData>, activity: MainActivity, difference: Int,countlistitem:Int) {
        this.activity = activity
        this.difference = difference
        this.countlistitem = countlistitem
        this.songListItems.clear()
        this.songListItems.addAll(song)
        notifyDataSetChanged()
    }

    inner class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.titleTextView.text = ""
            itemView.listview_songs_data.adapter = null
        }

        fun onBind(position: Int) {

            val (id, name, album, artist) = songListItems[position].song
            val (songs) = songListItems[position]

            if (difference == 0) {
                inflateData(id, name, artist, songs)
            } else {
                inflateData(id, name, album, songs)
            }


        }


        private fun inflateData(id: Long?, title: String?, album: String?, songs: List<Song>) {
            album?.let { itemView.titleTextView.text = it }
            if (countlistitem<songs.size){
                itemView.listview_songs_data.layoutManager =GridLayoutManager(activity, countlistitem, RecyclerView.HORIZONTAL, false)
            }else
            {
                itemView.listview_songs_data.layoutManager =GridLayoutManager(activity, songs.size, RecyclerView.HORIZONTAL, false)
            }

            val songsDataAdapter = SongsDataAdapter(ArrayList())
            songsDataAdapter.addSongsToList(songs)
            itemView.listview_songs_data.adapter = songsDataAdapter

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_song_list, parent, false)
        )
    }


}
