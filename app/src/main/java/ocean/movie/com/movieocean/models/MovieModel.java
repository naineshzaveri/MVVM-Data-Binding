package ocean.movie.com.movieocean.models;

/**
 * Created by naineshzaveri on 23/07/16.
 */
public class MovieModel implements java.io.Serializable{

    private String id;
    private String title;
    private int year;
    private String mpaa_rating;
    private int runtime;
    private ReleaseDate release_dates;
    private Ratings ratings;
    private String synopsis;
    private Posters posters;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public ocean.movie.com.movieocean.models.MovieModel.ReleaseDate getRelease_dates() {
        return release_dates;
    }

    public void setRelease_dates(ocean.movie.com.movieocean.models.MovieModel.ReleaseDate release_dates) {
        this.release_dates = release_dates;
    }

    public ocean.movie.com.movieocean.models.MovieModel.Ratings getRatings() {
        return ratings;
    }

    public void setRatings(ocean.movie.com.movieocean.models.MovieModel.Ratings ratings) {
        this.ratings = ratings;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public ocean.movie.com.movieocean.models.MovieModel.Posters getPosters() {
        return posters;
    }

    public void setPosters(ocean.movie.com.movieocean.models.MovieModel.Posters posters) {
        this.posters = posters;
    }

    public class ReleaseDate implements java.io.Serializable{

        String theater;

        public String getTheater() {
            return ocean.movie.com.movieocean.utils.Utility.convertDatFormat(this.theater, ocean.movie.com.movieocean.utils.Utility.YYYY_MM_DD_FORMAT, ocean.movie.com.movieocean.utils.Utility.APP_DATE_FORMAT);
        }

        public void setTheater(String theater) {
            this.theater = theater;
        }
    }

    public class Ratings implements java.io.Serializable{

        private String critics_rating;
        private int critics_score;
        private String audience_rating;
        private int audience_score;

        public String getCritics_rating() {
            return critics_rating;
        }

        public void setCritics_rating(String critics_rating) {
            this.critics_rating = critics_rating;
        }

        public int getCritics_score() {
            return critics_score;
        }

        public void setCritics_score(int critics_score) {
            this.critics_score = critics_score;
        }

        public String getAudience_rating() {
            return audience_rating;
        }

        public void setAudience_rating(String audience_rating) {
            this.audience_rating = audience_rating;
        }

        public int getAudience_score() {
            return audience_score;
        }

        public void setAudience_score(int audience_score) {
            this.audience_score = audience_score;
        }
    }

    public class Posters implements java.io.Serializable {
        private String thumbnail;
        private String profile;
        private String detailed;
        private String original;

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getDetailed() {
            return detailed;
        }

        public void setDetailed(String detailed) {
            this.detailed = detailed;
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
        }
    }

}