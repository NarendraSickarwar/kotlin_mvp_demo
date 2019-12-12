package com.app.horizentallistview.ui.mainactivity.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.horizentallistview.R
import com.app.horizentallistview.data.data.database.repository.songs.Song
import kotlinx.android.synthetic.main.item_song_data_list.view.*

/**
 * Created by Narendra Singh on 12/6/2019.
 */
class SongsDataAdapter (private val songListItems: MutableList<Song>) : RecyclerView.Adapter<SongsDataAdapter.SongDataViewHolder>() {

    override fun getItemCount() = this.songListItems.size

    override fun onBindViewHolder(holder: SongDataViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }


    internal fun addSongsToList(songs: List<Song>) {
        this.songListItems.addAll(songs)
        notifyDataSetChanged()
    }

    inner class SongDataViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {

        }

        fun onBind(position: Int) {

            val (id, name, author, arist) = songListItems[position]
            Log.d("name",name)

            inflateData(id, name, author, arist)

        }


        private fun inflateData(id: Long?, title: String?, author: String?, date: String?) {
            title?.let { itemView.nameTextView.text = it }

            //description?.let { itemView.contentTextView.text = it }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongDataViewHolder {
        return SongDataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_song_data_list, parent, false)


        )
    }
}