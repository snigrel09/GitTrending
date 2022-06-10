package `in`.android.gittrending.dao

import `in`.android.gittrending.entity.TrendingGit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query


@Dao
interface TrendingGitDAO {

    @Insert(onConflict = REPLACE)
    fun insertTrendingGIT(trendingGit: TrendingGit): Long

    @Query("Select * from trending_git_table")
    fun getAllTrendingGIT(): List<TrendingGit>

    @Query("Select * from trending_git_table where repository_id = :repositoryId")
    fun getSelectedTrendingGIT(repositoryId: Int): TrendingGit

    @Query("Delete from trending_git_table")
    fun deleteAllTrendingGIT()


}