package com.app.horizentallistview.ui.main.presenter

import com.app.horizentallistview.data.data.database.repository.songs.SongRepo
import com.app.horizentallistview.data.network.SongResponse
import com.app.horizentallistview.data.util.SchedulerProvider
import com.app.horizentallistview.ui.base.presenter.BasePresenter
import com.app.horizentallistview.ui.main.interactor.MainMVPInteractor

import com.app.horizentallistview.ui.mainactivity.view.MainMVPView


import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Narendra Singh on 12/6/2019.
 */

class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(private val songRepoHelper: SongRepo, interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)


       getAlbumSongsData()
    }


    private fun getSongsData() = interactor?.let {
        compositeDisposable.add(it.getSongsData()
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe({ songdata ->
                getView()?.let {
                    if (songdata.isEmpty()) return@subscribe
                    else it.displaySongsData(songdata)
                }
            }, { err -> println(err) }))
    }

    override fun refreshSongsData(): Boolean?  = getSongsData()
    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            it.makeSongApiCall()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe { songResponse ->
                    getView()?.let {
                        it.hideProgress()
                        saveSongDatabase(songResponse)


                    }
                }
        }
    }

    override fun saveSongDatabase(songResponse: SongResponse) {
        getView()?.showProgress()
        interactor?.let {
            it.saveSongApiCall(songResponse)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe { songResponse ->
                    getView()?.let {
                        it.hideProgress()



                    }
                }
        }
    }

    override fun getArtistSongsData() = interactor?.let {
        compositeDisposable.add(it.getArtistSongsData()
            .compose(schedulerProvider.ioToMainSingleScheduler())
            .subscribe({ songData ->
                getView()?.let {
                    if (songData.isEmpty()) return@subscribe
                    else it.displayArtistSongsData(songData)
                }
            }, { err -> println(err) }))
    }

    override fun getAlbumSongsData() = interactor?.let {
        compositeDisposable.add(it.getAlbumSongsData()
            .compose(schedulerProvider.ioToMainSingleScheduler())
            .subscribe({ songData ->
                getView()?.let {
                    if (songData.isEmpty()) return@subscribe
                    else it.displayAlbumSongsData(songData)
                }
            }, { err -> println(err) }))
    }

    override fun onGetDataOnAlbum() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}