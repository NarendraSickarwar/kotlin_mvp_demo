package com.app.horizentallistview.ui.mainactivity.view


import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.horizentallistview.R
import com.app.horizentallistview.data.data.database.repository.songs.Song
import com.app.horizentallistview.data.util.NetworkUtils
import com.app.horizentallistview.data.util.extension.removeFragment
import com.app.horizentallistview.ui.base.view.BaseActivity
import com.app.horizentallistview.ui.main.interactor.MainMVPInteractor
import com.app.horizentallistview.ui.main.interactor.SongsData
import com.app.horizentallistview.ui.main.presenter.MainMVPPresenter
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

/**
 * Created by Narendra Singh on 12/6/2019.
 */

class MainActivity : BaseActivity(), MainMVPView, NavigationView.OnNavigationItemSelectedListener
     {

    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>

    @Inject
    internal lateinit var songAdapter: SongAdapter
    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    var lang = arrayOf("Artist", "Album")
    var count = arrayOf("2", "3", "4", "5")
    val NEW_SPINNER_ID = 1
    var countspinnervalue:Int=1
         var difference:Int=0
         var  song: List<SongsData> = ArrayList()
         override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        listview.layoutManager = layoutManager
        listview.itemAnimator = DefaultItemAnimator()
        listview.adapter = songAdapter
//spinner set
        var aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, lang)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(artist_spinner)
        {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                    if (position == 0)
                        presenter.getArtistSongsData()
                    else {
                        presenter.getAlbumSongsData()
                    }


                }

                override fun onNothingSelected(parent: AdapterView<*>){
                    // Another interface callback
                }
            }
            prompt = "Select"
            gravity = Gravity.CENTER

        }


        aa = ArrayAdapter(this, R.layout.spinner_right_aligned, count)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)



        countspinner.adapter = aa

        countspinner.setSelection(0, false)
        countspinner.onItemSelectedListener =object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                    countspinnervalue=count[position].toInt()
                    songAdapter.addSongsToList(song, this@MainActivity , difference,countspinnervalue)
                    listview.adapter = songAdapter
                    songAdapter.notifyDataSetChanged()

                }

                override fun onNothingSelected(parent: AdapterView<*>){
                    // Another interface callback
                }
            }

        countspinner.prompt = "Select"






    }

    override fun setUp() {
        if(NetworkUtils.isNetworkConnected(this)) {
            presenter.onViewPrepared()
        }else{
            presenter.getAlbumSongsData()
        }
    }


    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentDetached(tag: String) {
        supportFragmentManager?.removeFragment(tag = tag)

    }

    override fun onFragmentAttached() {


    }


    override fun displaySongsData(songs: List<Song>) {
        Log.d("songsdata", "" + songs.size)


    }

    override fun displayArtistSongsData(songs: List<SongsData>) {
        song=songs
        difference=0
        songAdapter.addSongsToList(songs, this, difference,countspinnervalue)
        listview.adapter = songAdapter
        songAdapter.notifyDataSetChanged()
    }

    override fun displayAlbumSongsData(songs: List<SongsData>) {
        song=songs
        difference=1
        songAdapter.addSongsToList(songs, this, difference,countspinnervalue)
        listview.adapter = songAdapter
        songAdapter.notifyDataSetChanged()
    }



         override fun onNavigationItemSelected(p0: MenuItem): Boolean {
             TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
         }


     }


