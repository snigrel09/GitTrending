package `in`.android.gittrending.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "trending_git_table")
data class TrendingGit(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "repository_id")
    val repositoryId: Int,

    @ColumnInfo(name = "author_name")
    val authorName: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "avatar")
    val avatar: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "language")
    val language: String,

    @ColumnInfo(name = "languageColor")
    val languageColor: String,

    @ColumnInfo(name = "stars")
    val stars: String,

    @ColumnInfo(name = "forks")
    val forks: String,

    @ColumnInfo(name = "currentPeriodStars")
    val currentPeriodStars: String,

)
