package `in`.android.gittrending.model



data class TrendingGitData(
    val author: String,
    val name: String,
    val avatar: String,
    val url: String,
    val description: String,
    val language: String,
    val languageColor: String,
    val stars: String,
    val forks: String,
    val currentPeriodStars: String,
    val builtBy: ArrayList<CreatorsData>
)

data class CreatorsData(
    val username: String,
    val href: String,
    val avatar: String
)
