package `in`.android.gittrending.retrofit

class ApiUtils {
    companion object{
        private val TAG = "ApiUtils"

        private const val api_url = "https://github-trending-api-wonder.herokuapp.com"


        private var objWebAPI: ApiUtils? = null

        fun getInstance(): ApiUtils? {
            if (objWebAPI == null) {
                objWebAPI = ApiUtils()
            }
            return objWebAPI
        }

        fun getUrl(): ApiInterface? {
            return ApiClient.getClient(api_url).create(ApiInterface::class.java)
        }



    }
}