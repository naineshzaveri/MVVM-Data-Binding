package ocean.movie.com.movieocean.activity;
/**
 * Created by naineshzaveri on 24/07/16.
 */
public class MovieDetailActivity extends ocean.movie.com.movieocean.base.BaseActivity {
private ocean.movie.com.movieocean.models.MovieModel movieModel;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ocean.movie.com.movieocean.R.layout.activity_moiewdetail);

        getBundleValues();
        setMovieData();
    }

    private void getBundleValues(){
        movieModel = (ocean.movie.com.movieocean.models.MovieModel) getIntent().getExtras().getSerializable(ocean.movie.com.movieocean.utils.BundleKeys.KEY_MOVIE);
        setTitle(movieModel.getTitle());
    }

    private void setMovieData(){

        if(movieModel != null){
            ((android.widget.TextView)findViewById(ocean.movie.com.movieocean.R.id.txtReleaseDate)).setText(movieModel.getRelease_dates().getTheater());
            ((android.widget.TextView)findViewById(ocean.movie.com.movieocean.R.id.txtUserRatings)).setText(""+movieModel.getRatings().getAudience_rating());
            ((android.widget.TextView)findViewById(ocean.movie.com.movieocean.R.id.txtSynopsis)).setText("" + movieModel.getSynopsis());
            ocean.movie.com.movieocean.utils.BitmapUtils.setMovieThumbail(this, movieModel.getPosters().getDetailed(), (android.widget.ImageView) findViewById(ocean.movie.com.movieocean.R.id.ivMovieImage));
        }
    }
}
