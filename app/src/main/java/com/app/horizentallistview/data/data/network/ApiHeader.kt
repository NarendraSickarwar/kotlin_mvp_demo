package com.app.horizentallistview.data.network

import javax.inject.Inject

/**
 * Created by Narendra Singh on 12/6/2019.
 */

class ApiHeader @Inject constructor(internal val publicApiHeader: PublicApiHeader, internal val protectedApiHeader: ProtectedApiHeader) {

    class PublicApiHeader @Inject constructor()

    class ProtectedApiHeader @Inject constructor()

}