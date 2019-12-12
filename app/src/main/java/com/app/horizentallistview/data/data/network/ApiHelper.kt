package com.app.horizentallistview.data.network

import io.reactivex.Observable

/**
 * Created by Narendra Singh on 12/6/2019.
 */

interface ApiHelper {



    fun getSongApiCall(): Observable<SongResponse>



}