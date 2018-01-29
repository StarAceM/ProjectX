package starace.com.projectx;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by mstarace on 1/29/18.
 */

public class ConnectionHelper {

    public static boolean checkForConnection(Context context) {
        ConnectivityManager ConnectionManager = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(ConnectionManager != null) {
            NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }

        return false;
    }
}
