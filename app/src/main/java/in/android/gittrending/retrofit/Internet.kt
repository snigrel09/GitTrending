package `in`.android.gittrending.retrofit

import android.content.Context
import android.net.ConnectivityManager
import android.telephony.TelephonyManager

class Internet {
    companion object {
        fun checkConnection(c: Context): Boolean {
            val mConnectivityManager = c
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val ni = mConnectivityManager.activeNetworkInfo
            return ni != null
        }
    }
}