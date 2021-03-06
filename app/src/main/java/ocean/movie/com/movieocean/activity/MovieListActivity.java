package ocean.movie.com.movieocean.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import ocean.movie.com.movieocean.R;
import ocean.movie.com.movieocean.models.MovieModel;

;

public class MovieListActivity extends ocean.movie.com.movieocean.base.BaseActivity implements ocean.movie.com.movieocean.moviemanager.MovieListManager.MovieValueListener {

    private android.support.v7.widget.RecyclerView.Adapter mAdapter;
    private android.support.v7.widget.RecyclerView mRecyclerView;
    private android.widget.ProgressBar mProgress;
    private android.widget.TextView txtEmptyView;
    private java.util.ArrayList<MovieModel> modelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ocean.movie.com.movieocean.R.layout.activity_home);
        setTitle(getResources().getString(ocean.movie.com.movieocean.R.string.movie_list));

        init();

        if(!ocean.movie.com.movieocean.utils.NetworkUtil.checkNetworkAvailable(this)){
            showProgress(true);
            this.modelArrayList.clear();
            this.modelArrayList = ocean.movie.com.movieocean.moviemanager.MovieListManager.getInstance().getAllMoviesFromDb();
            setMoviePosterAdapter();
            showProgress(false);
        }else{
            getMovieList();
        }
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rclPatientDetails);
        mRecyclerView.setLayoutManager(new ocean.movie.com.movieocean.customviews.RecyclerLinearLayoutManager(this));
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        txtEmptyView = (TextView) findViewById(R.id.txtEmptyView);
    }

    private void setMoviePosterAdapter() {

        if (modelArrayList != null && modelArrayList.size() > 0) {
            if (mAdapter == null) {
                mAdapter = new ocean.movie.com.movieocean.adapters.MovieListAdapter(MovieListActivity.this, modelArrayList,movieClickListener);
                mRecyclerView.setAdapter(mAdapter);
            } else {
                mAdapter.notifyDataSetChanged();
            }
            mRecyclerView.setVisibility(android.view.View.VISIBLE);
            txtEmptyView.setVisibility(android.view.View.GONE);
        } else {
            mRecyclerView.setVisibility(android.view.View.GONE);
            txtEmptyView.setVisibility(android.view.View.VISIBLE);
        }
    }

    @Override
    public void onReturnMovieList(java.util.List<ocean.movie.com.movieocean.models.MovieModel> movieModels) {

        this.modelArrayList.clear();
        this.modelArrayList.addAll(movieModels);
        showProgress(false);
        setMoviePosterAdapter();
    }

    @Override
    public void onReturnError(com.android.volley.VolleyError error) {

        showProgress(false);
        android.widget.Toast.makeText(this, getResources().getString(R.string.error_fetching_data), android.widget.Toast.LENGTH_SHORT).show();
        setMoviePosterAdapter();
    }

    private void showProgress(boolean show) {
        if (show) {
            mProgress.setVisibility(android.view.View.VISIBLE);
            mRecyclerView.setVisibility(android.view.View.GONE);

        } else {
            mProgress.setVisibility(android.view.View.GONE);
            mRecyclerView.setVisibility(android.view.View.VISIBLE);
        }
    }

    private void getMovieList() {
        if (ocean.movie.com.movieocean.utils.NetworkUtil.checkNetworkAvailable(this)) {
            showProgress(true);
            ocean.movie.com.movieocean.moviemanager.MovieListManager.getInstance().getMovieList(this);

        } else {
            showProgress(false);
            android.widget.Toast.makeText(this, getResources().getString(R.string.error_no_internet), android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    private android.view.View.OnClickListener movieClickListener = new android.view.View.OnClickListener() {
        @Override
        public void onClick(android.view.View v) {

            switch (v.getId()){
                case R.id.cvMoviePoster:
                    ocean.movie.com.movieocean.models.MovieModel movieModel = (MovieModel) v.getTag();
                    android.content.Intent intent = new android.content.Intent(MovieListActivity.this, ocean.movie.com.movieocean.activity.MovieDetailActivity.class);
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putSerializable(ocean.movie.com.movieocean.utils.BundleKeys.KEY_MOVIE, movieModel);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case R.id.ivPoster:
                    ocean.movie.com.movieocean.models.MovieModel movieModelPoster = (MovieModel) v.getTag();
                    android.content.Intent imageViewintent = new android.content.Intent(MovieListActivity.this, ocean.movie.com.movieocean.activity.CarouselActivity.class);
                    android.os.Bundle imageViewBundle = new android.os.Bundle();
                    imageViewBundle.putSerializable(ocean.movie.com.movieocean.utils.BundleKeys.KEY_MOVIE, movieModelPoster);
                    imageViewintent.putExtras(imageViewBundle);
                    startActivity(imageViewintent);
                    break;

            }


        }
    };
}
