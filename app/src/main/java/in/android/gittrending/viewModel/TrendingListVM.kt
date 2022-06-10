package `in`.android.gittrending.viewModel

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

class TrendingListVM(application: Application) : AndroidViewModel(application) {
    val context = application
    val data = MutableLiveData<ArrayList<TrendingGit>>()
    val size = MutableLiveData<String>("0")

    fun getTrendingData() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataTrending = MyDatabase.getDatabase(context).trendingDao().getAllTrendingGIT() as ArrayList
                data.postValue(dataTrending)
        }
    }


}