package com.app.horizentallistview.data.data.database.repository.songs




import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Narendra Singh on 12/6/2019.
 */

@Entity(tableName = "songs")
data class Song(
        @Expose
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @Expose
        @SerializedName("Name")
        @ColumnInfo(name = "name")
        var nameText: String,

        @Expose
        @SerializedName("Artist")
        @ColumnInfo(name = "artist")
        var artistText: String,

        @Expose
        @SerializedName("Album")
        @ColumnInfo(name = "album")
        var albumText: String



//{"data":[{"Name":"Aaj Kal Zindagi","Artist":"Shankar Mahadevan","Album":"Wake Up Sid"},{"Name":"ALL GONE","Artist":"Crawdad Republic","Album":"CRAWDAD REPUBLIC"},{"Name":"California","Artist":"U2","Album":"Songs of Innocence"},{"Name":"CAN'T KEEP A GOOD MAN DOWN","Artist":"Crawdad Republic","Album":"CRAWDAD REPUBLIC"},{"Name":"Cedarwood Road","Artist":"U2","Album":"Songs of Innocence"},{"Name":"Closure","Artist":"Opeth","Album":"Damnation"},{"Name":"Death Whispered A Lullaby","Artist":"Opeth","Album":"Damnation"},{"Name":"Der Lagi Lekin","Artist":"Shankar Mahadevan","Album":"Zindagi Na Milegi Dobara"},{"Name":"DUST OFF YOUR BOOTS","Artist":"Crawdad Republic","Album":"CRAWDAD REPUBLIC"},{"Name":"Ending Credits","Artist":"Opeth","Album":"Damnation"},{"Name":"Every Breaking Wave","Artist":"U2","Album":"Songs of Innocence"},{"Name":"Geet","Artist":"Amit Trivedi","Album":"Udaan"},{"Name":"GET ENOUGH","Artist":"Crawdad Republic","Album":"CRAWDAD REPUBLIC"},{"Name":"Hope Leaves","Artist":"Opeth","Album":"Damnation"},{"Name":"ICEBERG MEADOWS","Artist":"Crawdad Republic","Album":"CRAWDAD REPUBLIC"},{"Name":"In My Time Of Need","Artist":"Opeth","Album":"Damnation"},{"Name":"Iris","Artist":"U2","Album":"Songs of Innocence"},{"Name":"LONG AND THE SHORT OF IT","Artist":"Crawdad Republic","Album":"CRAWDAD REPUBLIC"},{"Name":"Manja","Artist":"Amit Trivedi","Album":"Kai Po Che (2013)"},{"Name":"Maston Ka Jhund","Artist":"Shankar Mahadevan","Album":"Bhaag Milkha Bhaag (2013)"},{"Name":"NOTHING TO SHOW","Artist":"Crawdad Republic","Album":"CRAWDAD REPUBLIC"},{"Name":"Raised By Wolves","Artist":"U2","Album":"Songs of Innocence"},{"Name":"Sleep Like a Baby Tonight","Artist":"U2","Album":"Songs of Innocence"},{"Name":"Slow Motion Angreza","Artist":"Shankar Mahadevan","Album":"Bhaag Milkha Bhaag (2013)"},{"Name":"Song for Someone","Artist":"U2","Album":"Songs of Innocence"},{"Name":"STONES RIVER","Artist":"Crawdad Republic","Album":"CRAWDAD REPUBLIC"},{"Name":"The Miracle","Artist":"U2","Album":"Songs of Innocence"},{"Name":"The Troubles","Artist":"U2","Album":"Songs of Innocence"},{"Name":"This Is Where You Can Reach Me Now","Artist":"U2","Album":"Songs of Innocence"},{"Name":"To Rid The Disease","Artist":"Opeth","Album":"Damnation"},{"Name":"Volcano","Artist":"U2","Album":"Songs of Innocence"},{"Name":"WE'RE ALL GONNA DIE","Artist":"Crawdad Republic","Album":"CRAWDAD REPUBLIC"},{"Name":"Weakness","Artist":"Opeth","Album":"Damnation"},{"Name":"WHEN NO ONE IS AROUND","Artist":"Crawdad Republic","Album":"CRAWDAD REPUBLIC"},{"Name":"Windowpane","Artist":"Opeth","Album":"Damnation"},{"Name":"Zinda","Artist":"Amit Trivedi","Album":"Lootera (2013)"},{"Name":"Zinda","Artist":"Shankar Mahadevan","Album":"Bhaag Milkha Bhaag (2013)"}]}

)