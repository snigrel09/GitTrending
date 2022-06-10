package `in`.android.gittrending.activity

import `in`.android.gittrending.R
import `in`.android.gittrending.adapter.CreatorAdapter
import `in`.android.gittrending.databinding.ActivityDetailsBinding
import `in`.android.gittrending.databinding.ActivityMainBinding
import `in`.android.gittrending.viewModel.DetailsVM
import `in`.android.gittrending.viewModel.TrendingListVM
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailsActivity : AppCompatActivity() {
    private var _binding: ActivityDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DetailsVM
    private var repositoryId: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[DetailsVM::class.java]

        if (intent.extras != null) {
            repositoryId = intent.extras!!.getInt("TrendingId")
        }

        binding.creatorRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        viewModel.getCreatorData(repositoryId)

        viewModel.dataTrending.observe(this) {
            binding.data = it
        }

        viewModel.dataCreators.observe(this) {
            binding.creatorRv.adapter = CreatorAdapter(this, viewModel)
        }

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}