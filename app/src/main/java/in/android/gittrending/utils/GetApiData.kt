package `in`.android.gittrending.utils

import `in`.android.gittrending.entity.Creator
import `in`.android.gittrending.entity.TrendingGit
import `in`.android.gittrending.retrofit.ApiUtils
import `in`.android.gittrending.retrofit.Internet
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class GetApiData(private val context: Context, private val params: WorkerParameters) :
    CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        val trendingGitDAO = MyDatabase.getDatabase(applicationContext).trendingDao()
        val creatorDAO = MyDatabase.getDatabase(applicationContext).creatorDao()
        val apiInterface = ApiUtils.getUrl()!!

        if (Internet.checkConnection(applicationContext)) {
            val call = apiInterface.getTrendingList()
            val response = call.execute()
            if (response.isSuccessful) {
                var responseData = response.body()!!
                responseData.let {
                    if (it.size > 0) {
                        if (trendingGitDAO.getAllTrendingGIT().isNotEmpty()) {
                            trendingGitDAO.deleteAllTrendingGIT()
                        }
                    }
                    for (items in it) {

                        val gitData = TrendingGit(
                            0,
                            items.author?:"",
                            items.name?:"",
                            items.avatar?:"",
                            items.url?:"",
                            items.description?:"",
                            items.language?:"",
                            items.languageColor?:"",
                            items.stars?:"",
                            items.forks?:"",
                            items.currentPeriodStars?:""
                        )

                        val id = trendingGitDAO
                            .insertTrendingGIT(trendingGit = gitData)
                        for (creator in items.builtBy) {
                            creatorDAO.insertCreator(
                                Creator(
                                    0,
                                    id.toInt(),
                                    creator.username?:"",
                                    creator.href?:"",
                                    creator.avatar?:""
                                )
                            )
                        }
                    }

                }
                return Result.success()
            } else {
                return Result.success()
            }
        } else {
            return Result.retry()
        }

    }
}