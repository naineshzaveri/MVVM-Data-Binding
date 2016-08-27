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

            ocean.movie.com.movieocean.databinding.ActivityMoiewdetailBinding binding =
                    android.databinding.DataBindingUtil.setContentView(this, ocean.movie.com.movieocean.R.layout.activity_moiewdetail);
            binding.setMovieData(movieModel);
        }
    }
}
