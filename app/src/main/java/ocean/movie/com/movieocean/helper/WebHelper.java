package ocean.movie.com.movieocean.helper;

/**
 * Web-service related constants
 */
public interface WebHelper {

    String API_KEY = "9txsnh3qkb5ufnphhqv5tv5z";

    public interface RequestUrl {

        String BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
        String MOVIE_LIST = BASE_URL + "lists/movies/box_office.json?";
    }

    /**
     * Web-service Params fields
     */
    public interface Params {
        String API_KEY = "apikey";
    }
}
