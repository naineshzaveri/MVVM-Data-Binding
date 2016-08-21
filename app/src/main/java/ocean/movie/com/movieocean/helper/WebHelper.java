package ocean.movie.com.movieocean.helper;

/**
 * Web-service related constants
 */
public interface WebHelper {

    String API_KEY = "9txsnh3qkb5ufnphhqv5tv5z";

    public interface RequestUrl {

        String BASE_URL = "http://private-a5ac3-themoviedb.apiary-proxy.com/3/";
        String IMAGE_URL = "http://image.tmdb.org/t/p/w500/";
        String MOVIE_LIST = BASE_URL + "discover/movie?";
    }

    /**
     * Web-service Params fields
     */
    public interface Params {
        String API_KEY = "api_key";
    }

    public interface HeaderParams {
        String ACCEPT = "accept";
        String SORT_BY = "sort_by";
    }
    public interface  PARAMS_VALUE{
        String SORT_BY_POPULARITY = "popularity.desc";
        String SORT_BY_HIGEST_RATING = "vote_count.desc";

    }
}
