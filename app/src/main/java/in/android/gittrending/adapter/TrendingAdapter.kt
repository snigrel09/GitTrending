package `in`.android.gittrending.adapter

import `in`.android.gittrending.activity.DetailsActivity
import `in`.android.gittrending.databinding.ItemTrendingGitBinding
import `in`.android.gittrending.viewModel.TrendingListVM
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView

class TrendingAdapter(var activity: Activity, var viewModel: TrendingListVM) :
    RecyclerView.Adapter<TrendingAdapter.TrendingVH>() {

    inner class TrendingVH(view: ItemTrendingGitBinding) : RecyclerView.ViewHolder(view.root) {
        val view: ItemTrendingGitBinding

        init {
            this.view = view
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingVH {
        val bindingView =
            ItemTrendingGitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendingVH(bindingView)
    }

    override fun onBindViewHolder(holder: TrendingVH, position: Int) {
        holder.view.data = viewModel.data.value!![position]
        holder.view.root.setOnClickListener {
            var intent = Intent(activity,DetailsActivity::class.java)
            intent.putExtra("TrendingId",viewModel.data.value!![position].repositoryId)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return viewModel.data.value!!.size
    }
}