package ocean.movie.com.movieocean.utils;

/**
 * NetworkUtil checks available network
 * 
 * @author Lemon
 */
public class NetworkUtil {
	
	public static final int TYPE_WIFI = 1;
    public static final int TYPE_MOBILE = 2;
    public static final int TYPE_NOT_CONNECTED = 0;
    public static boolean isNetworkSateChanged = false; 

	/**
	 * Check network connection
	 * 
	 * @param context
	 * @return
	 */
	public static boolean checkNetworkAvailable(android.content.Context context) {

		android.net.ConnectivityManager conMgr = (android.net.ConnectivityManager) context
				.getSystemService(android.content.Context.CONNECTIVITY_SERVICE);
		android.net.NetworkInfo i = conMgr.getActiveNetworkInfo();
		if (i == null) {
			return false;
		}
		if (!i.isConnected()) {
			return false;
		}
		if (!i.isAvailable()) {
			return false;
		}
		return true;
	}
}
