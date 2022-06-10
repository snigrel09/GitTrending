package `in`.android.gittrending.viewModel

import `in`.android.gittrending.entity.Creator
import `in`.android.gittrending.entity.TrendingGit
import `in`.android.gittrending.utils.MyDatabase
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsVM(application: Application) : AndroidViewModel(application) {
    val context = application
    val dataTrending = MutableLiveData<TrendingGit>()
    val dataCreators = MutableLiveData<ArrayList<Creator>>()

    fun getCreatorData(repositoryId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val trending = MyDatabase.getDatabase(context).trendingDao().getSelectedTrendingGIT(repositoryId)
            dataTrending.postValue(trending)
            val dataCreator = MyDatabase.getDatabase(context).creatorDao().getAllCreators(repositoryId) as ArrayList
            dataCreators.postValue(dataCreator)
        }
    }


}