package ocean.movie.com.movieocean.models;

/**
 * Created by naineshzaveri on 23/07/16.
 */
public class MovieModel extends android.databinding.BaseObservable implements java.io.Serializable{

    private String id;
    private String title;
    private int year;
    private String mpaa_rating;
    private int runtime;

    private ReleaseDate release_dates;
    private Ratings ratings;
    private String synopsis;
    private Posters posters;

    MovieModel(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @android.databinding.Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.title);
    }

    @android.databinding.Bindable
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.year);
    }

    @android.databinding.Bindable
    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    @android.databinding.Bindable
    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @android.databinding.Bindable
    public ocean.movie.com.movieocean.models.MovieModel.ReleaseDate getRelease_dates() {
        return release_dates;
    }

    public void setRelease_dates(ocean.movie.com.movieocean.models.MovieModel.ReleaseDate release_dates) {
        this.release_dates = release_dates;
        notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.release_dates);
    }

    @android.databinding.Bindable
    public ocean.movie.com.movieocean.models.MovieModel.Ratings getRatings() {
        return ratings;
    }

    public void setRatings(ocean.movie.com.movieocean.models.MovieModel.Ratings ratings) {
        this.ratings = ratings;
        notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.ratings);
    }

    @android.databinding.Bindable
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.synopsis);
    }

    @android.databinding.Bindable
    public Posters getPosters() {
        return posters;
    }

    public void setPosters(Posters posters) {
        this.posters = posters;
        notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.posters);
    }

    public class ReleaseDate extends android.databinding.BaseObservable implements java.io.Serializable{

        ReleaseDate(){

        }

        private String theater;

        @android.databinding.Bindable
        public String getTheater() {
            return  ocean.movie.com.movieocean.utils.Utility.convertDatFormat(this.theater, ocean.movie.com.movieocean.utils.Utility.YYYY_MM_DD_FORMAT, ocean.movie.com.movieocean.utils.Utility.APP_DATE_FORMAT);
        }
        public void setTheater(String theater) {
            this.theater = theater;
            notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.theater);
        }
    }

    public class Ratings extends android.databinding.BaseObservable implements java.io.Serializable {

        private String critics_rating;
        private int critics_score;
        private String audience_rating;
        private int audience_score;

        Ratings(){

        }
        @android.databinding.Bindable
        public String getCritics_rating() {
            return critics_rating;
        }

        public void setCritics_rating(String critics_rating) {
            this.critics_rating = critics_rating;
            notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.critics_rating);
        }

        @android.databinding.Bindable
        public int getCritics_score() {
            return critics_score;
        }

        public void setCritics_score(int critics_score) {
            this.critics_score = critics_score;
            notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.critics_score);
        }

        @android.databinding.Bindable
        public String getAudience_rating() {
            return audience_rating;

        }

        public void setAudience_rating(String audience_rating) {
            this.audience_rating = audience_rating;
            notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.audience_rating);
        }

        @android.databinding.Bindable
        public int getAudience_score() {
            return audience_score;
        }

        public void setAudience_score(int audience_score) {
            this.audience_score = audience_score;
            notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.audience_score);
        }
    }

}
