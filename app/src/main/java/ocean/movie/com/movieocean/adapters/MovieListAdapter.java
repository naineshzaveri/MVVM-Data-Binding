package ocean.movie.com.movieocean.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import ocean.movie.com.movieocean.R;
import ocean.movie.com.movieocean.models.MovieModel;

;

/**
 * Created by naineshzaveri on 23/07/16.
 */
public class MovieListAdapter extends Adapter<ViewHolder> {

    ArrayList<MovieModel> arrMovies;
    private Context mContext;

    public static class MoviePosterViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivMoviePoster;
        public CardView cvContent;
        public android.widget.ProgressBar progressBar;
        public android.widget.TextView txtMovieName, txtUserRatings, txtReleaseDate;

        public MoviePosterViewHolder(android.view.View v) {
            super(v);
            ivMoviePoster = (ImageView) v.findViewById(R.id.ivPoster);
            cvContent = (CardView) v.findViewById(R.id.cvMoviePoster);
            txtMovieName = (android.widget.TextView) v.findViewById(ocean.movie.com.movieocean.R.id.txtName);
            progressBar = (android.widget.ProgressBar) v.findViewById(ocean.movie.com.movieocean.R.id.progressBar);
            txtReleaseDate = (android.widget.TextView) v.findViewById(ocean.movie.com.movieocean.R.id.txtReleaseDate);
            txtUserRatings = (android.widget.TextView) v.findViewById(ocean.movie.com.movieocean.R.id.txtUserRatings);
        }
    }

    public MovieListAdapter(android.content.Context context, ArrayList<MovieModel> arrMovies) {
        super();
        this.mContext = context;
        this.arrMovies = arrMovies;
    }

    @Override
    public void onBindViewHolder(final android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int position) {

        MovieListAdapter.MoviePosterViewHolder holder = (MovieListAdapter.MoviePosterViewHolder) viewHolder;
        MovieModel movieModel = arrMovies.get(position);
        ocean.movie.com.movieocean.utils.BitmapUtils.setUrlImageUsingPicasso(mContext, movieModel.getPosters().getOriginal(), holder.ivMoviePoster, holder.progressBar);
        holder.txtMovieName.setText(movieModel.getTitle());
        holder.txtReleaseDate.setText(movieModel.getRelease_dates().getTheater());
        holder.txtUserRatings.setText("" + movieModel.getRatings().getAudience_score());
        holder.cvContent.setOnClickListener(new NextActivityListener(movieModel));
    }

    @Override
    public int getItemCount() {
        return arrMovies.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_movie_poster, viewGroup, false);
        return new MovieListAdapter.MoviePosterViewHolder(view);
    }

    class NextActivityListener implements android.view.View.OnClickListener {
        MovieModel movieModel;

        NextActivityListener(MovieModel movieModel) {
            this.movieModel = movieModel;
        }

        @Override
        public void onClick(android.view.View v) {
            android.content.Intent intent = new android.content.Intent(mContext, ocean.movie.com.movieocean.activity.MovieDetailActivity.class);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putSerializable(ocean.movie.com.movieocean.utils.BundleKeys.KEY_MOVIE, movieModel);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
    }
}

