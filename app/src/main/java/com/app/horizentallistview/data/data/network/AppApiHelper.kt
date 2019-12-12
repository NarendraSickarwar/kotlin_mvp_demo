package com.app.horizentallistview.data.network

import com.app.horizentallistview.BuildConfig
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Narendra Singh on 12/6/2019.
 */

class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader) : ApiHelper {



    override fun getSongApiCall(): Observable<SongResponse> =
            Rx2AndroidNetworking.get(BuildConfig.BASE_URL)
                    .addHeaders(apiHeader.protectedApiHeader)
                    .build()
                    .getObjectObservable(SongResponse::class.java)




}