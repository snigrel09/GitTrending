package `in`.android.gittrending.retrofit

import `in`.android.gittrending.model.TrendingGitData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {

    @GET("/")
    fun getTrendingList(): Call<ArrayList<TrendingGitData>>
}