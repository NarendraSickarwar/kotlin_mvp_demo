package  com.app.horizentallistview.ui.splash.interactor






import android.content.Context
import com.app.horizentallistview.data.data.database.repository.songs.Song
import com.app.horizentallistview.data.data.database.repository.songs.SongRepo
import com.app.horizentallistview.data.data.preferences.PreferenceHelper
import com.app.horizentallistview.data.network.ApiHelper
import com.app.horizentallistview.ui.base.interactor.BaseInteractor
import com.mindorks.framework.mvp.ui.splash.interactor.SplashMVPInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Narendra Singh on 12/6/2019.
 */

class SplashInteractor @Inject constructor(private val mContext: Context, private val songRepoHelper: SongRepo,  preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper),
    SplashMVPInteractor {
    override fun getSong(): Observable<List<Song>> {
        return songRepoHelper.loadSongs()
    }


}