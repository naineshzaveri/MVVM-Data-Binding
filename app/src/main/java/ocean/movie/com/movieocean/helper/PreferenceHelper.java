package ocean.movie.com.movieocean.helper;

/**
 * The Class PreferenceHelper.
 */
public class PreferenceHelper {

    /**
     * The preferences.
     */

    public final static String MOVIE_LIST = "movie_list_top";


    public static android.content.SharedPreferences getSharedPreferences() {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(ocean.movie.com.movieocean.MovieOcean
                .getInstance());
    }

    /**
     * Adds the string.
     *
     * @param key   the key
     * @param value the value
     */
    public static void addString(String key, String value) {

        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void addBoolean(String key, boolean value) {

        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Adds the integer.
     *
     * @param key   the key
     * @param value the value
     */
    public static void addInteger(String key, int value) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void addFloat(String key, Float value) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public static void addLong(String key, long value) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * Clear.
     */
    public static void clear() {
        // here you get your prefrences by either of two methods
        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.clear();
        editor.commit();
    }

	/*
     *
	 * remove a particular key.
	 */

    public static void removeKey(String key) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * Gets the string.
     *
     * @param key the key
     * @return the string
     */
    public static String getString(String key) {
        return getSharedPreferences().getString(key, null);
    }

    public static String getSafeString(String key) {
        return getSharedPreferences().getString(key, "");
    }

    public static Integer getInteger(String key) {
        return getSharedPreferences().getInt(key, 0);
    }

    public static Float getFloat(String key) {
        return getSharedPreferences().getFloat(key, 0);
    }

    public static long getLong(String key) {
        return getSharedPreferences().getLong(key, 0);
    }

    public static Boolean getBoolean(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }

    public static void addMovies(String key, java.util.ArrayList<ocean.movie.com.movieocean.models.MovieModel> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
            com.google.gson.Gson gson = new com.google.gson.Gson();
            String json = gson.toJson(arrayList);
            editor.putString(key, json);
            editor.commit();
        } else {
            removeKey(key);
        }
    }

    public static java.util.ArrayList<ocean.movie.com.movieocean.models.MovieModel> getMovies(String key) {

        try {
            com.google.gson.Gson gson = new com.google.gson.Gson();
            String json = getSharedPreferences().getString(key, null);
            if (json == null)
                return null;
            java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<java.util.ArrayList<ocean.movie.com.movieocean.models.MovieModel>>() {
            }.getType();
            java.util.ArrayList<ocean.movie.com.movieocean.models.MovieModel> arrayList = gson.fromJson(json, type);
            return arrayList;
        } catch (Exception e) {
            return null;
        }

    }

}
