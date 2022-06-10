package `in`.android.gittrending.activity

import `in`.android.gittrending.R
import `in`.android.gittrending.adapter.TrendingAdapter
import `in`.android.gittrending.databinding.ActivityMainBinding
import `in`.android.gittrending.utils.GetApiData
import `in`.android.gittrending.viewModel.TrendingListVM
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private lateinit var viewModel: TrendingListVM
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[TrendingListVM::class.java]
        binding.viewModel = viewModel
        binding.trendingRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        setPeriodicWorkRequest()



        viewModel.data.observe(this) {
            binding.trendingRv.adapter = TrendingAdapter(this, viewModel)
        }
    }


    private fun setPeriodicWorkRequest() {
        val workManager = WorkManager.getInstance(this)

        val myConstraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val request = PeriodicWorkRequest.Builder(GetApiData::class.java, 15, TimeUnit.MINUTES)
            .setConstraints(myConstraints)
            .addTag("myWorkManager")
            .build()


        workManager.enqueueUniquePeriodicWork(
            "myWorkManager",
            ExistingPeriodicWorkPolicy.REPLACE, request
        )


        workManager.getWorkInfoByIdLiveData(request.id).observe(this) {
            if (it.state == WorkInfo.State.ENQUEUED)
                viewModel.getTrendingData()
        }
    }
}