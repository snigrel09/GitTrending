package `in`.android.gittrending.utils

import `in`.android.gittrending.dao.CreatorDAO
import `in`.android.gittrending.dao.TrendingGitDAO
import `in`.android.gittrending.entity.Creator
import `in`.android.gittrending.entity.TrendingGit
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TrendingGit::class, Creator::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun trendingDao() : TrendingGitDAO
    abstract fun creatorDao() : CreatorDAO

    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "MyDatabase_Trending"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}