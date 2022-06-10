package `in`.android.gittrending.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "creators_table"
)
data class Creator(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "creator_id")
    val creatorId: Int,

    @ColumnInfo(name = "repository_id")
    val repositoryId: Int,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "href")
    val href: String,

    @ColumnInfo(name = "avatar")
    val avatar: String,


    )
