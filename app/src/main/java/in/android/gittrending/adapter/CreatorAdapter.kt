package `in`.android.gittrending.adapter

import `in`.android.gittrending.activity.DetailsActivity
import `in`.android.gittrending.databinding.ItemCreatorBinding
import `in`.android.gittrending.databinding.ItemTrendingGitBinding
import `in`.android.gittrending.viewModel.DetailsVM
import `in`.android.gittrending.viewModel.TrendingListVM
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CreatorAdapter(var activity: Activity, var viewModel: DetailsVM) :
    RecyclerView.Adapter<CreatorAdapter.CreatorVH>() {

    inner class CreatorVH(view: ItemCreatorBinding) : RecyclerView.ViewHolder(view.root) {
        val view: ItemCreatorBinding

        init {
            this.view = view
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatorVH {
        val bindingView =
            ItemCreatorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreatorVH(bindingView)
    }

    override fun onBindViewHolder(holder: CreatorVH, position: Int) {
        holder.view.creatorData = viewModel.dataCreators.value!![position]
        Picasso.get().load(viewModel.dataCreators.value!![position].avatar)
            .into(holder.view.userImage)
    }

    override fun getItemCount(): Int {
        return viewModel.dataCreators.value!!.size
    }
}