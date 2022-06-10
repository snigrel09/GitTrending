package `in`.android.gittrending.dao

import `in`.android.gittrending.entity.Creator
import `in`.android.gittrending.entity.TrendingGit
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CreatorDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCreator(creator: Creator): Long

    @Query("Select * from creators_table where repository_id = :repositoryId")
    fun getAllCreators(repositoryId: Int): List<Creator>

    @Query("Delete from creators_table")
    fun deleteAllCreators()
}