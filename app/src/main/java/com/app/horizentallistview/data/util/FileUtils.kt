package com.app.horizentallistview.data.util

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset

/**
 * Created by Narendra Singh on 12/6/2019.
 */

object FileUtils {

    @Throws(IOException::class)
    fun loadJSONFromAsset(context: Context, jsonFileName: String): String {
        (context.assets).open(jsonFileName).let {
            val buffer = ByteArray(it.available())
            it.read(buffer)
            it.close()
            return String(buffer, Charset.forName("UTF-8"))
        }
    }
}
