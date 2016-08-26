package ocean.movie.com.movieocean.moviemanager;

import ocean.movie.com.movieocean.models.MovieModel;

/**
 * Created by naineshzaveri on 24/07/16.
 */
public class MovieListManager implements com.android.volley.Response.Listener, com.android.volley.Response.ErrorListener {
    private static String TAG = MovieListManager.class.getName();
    com.android.volley.Request.Priority priority = com.android.volley.Request.Priority.HIGH;
    @Override
    public void onErrorResponse(com.android.volley.VolleyError volleyError) {
        if(movieValueListener != null){
            movieValueListener.onReturnError(volleyError);
        }
    }

    @Override
    public void onResponse(Object o) {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        if(movieValueListener != null){
            java.util.ArrayList<ocean.movie.com.movieocean.models.MovieModel> arrayList = gson.fromJson(o.toString(), ocean.movie.com.movieocean.models.MovieResponseModel.class).getMovies();
            ocean.movie.com.movieocean.helper.PreferenceHelper.addMovies(ocean.movie.com.movieocean.helper.PreferenceHelper.MOVIE_LIST,arrayList);
            movieValueListener.onReturnMovieList(arrayList);
        }
    }

    public interface MovieValueListener {

        void onReturnMovieList(java.util.List<MovieModel> movieModels);

        void onReturnError(com.android.volley.VolleyError error);
    }


    private android.content.Context mContext;
    private MovieValueListener movieValueListener;
    private java.util.List<MovieModel> arrAddressDetails = new java.util.ArrayList<>();

    private static MovieListManager mMovieListManager;

    public static MovieListManager getInstance() {
        if (null == mMovieListManager) {
            mMovieListManager = new MovieListManager();
            return mMovieListManager;
        }
        return mMovieListManager;
    }

    public void getMovieList(final MovieValueListener movieValueListener) {

        this.movieValueListener = movieValueListener;
        final String MOVIEW_URL = ocean.movie.com.movieocean.helper.WebHelper.RequestUrl.MOVIE_LIST + ocean.movie.com.movieocean.helper.WebHelper.Params.API_KEY + "=" + ocean.movie.com.movieocean.helper.WebHelper.API_KEY;

        com.android.volley.toolbox.StringRequest strReq = new com.android.volley.toolbox.StringRequest(com.android.volley.Request.Method.GET,
                MOVIEW_URL,this,this );
        // Adding request to request queue
        ocean.movie.com.movieocean.MovieOcean.getInstance().addToRequestQueue(strReq, TAG);
    }
    public java.util.ArrayList<ocean.movie.com.movieocean.models.MovieModel> getAllMoviesFromDb(){

        return ocean.movie.com.movieocean.helper.PreferenceHelper.getMovies(ocean.movie.com.movieocean.helper.PreferenceHelper.MOVIE_LIST);
    }
}
