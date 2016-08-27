package ocean.movie.com.movieocean.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import ocean.movie.com.movieocean.R;
import ocean.movie.com.movieocean.models.MovieModel;

;

/**
 * Created by naineshzaveri on 23/07/16.
 */
public class MovieListAdapter  extends RecyclerView.Adapter<MovieListAdapter.BindingHolder> {

    ArrayList<MovieModel> arrMovies;
    private Context mContext;
    private ocean.movie.com.movieocean.databinding.RowMoviePosterBinding binding;
    private android.view.View.OnClickListener onClickListener;


    public MovieListAdapter(android.content.Context context, ArrayList<MovieModel> arrMovies,android.view.View.OnClickListener onClickListener) {
        super();
        this.mContext = context;
        this.arrMovies = arrMovies;
        this.onClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ocean.movie.com.movieocean.databinding.RowMoviePosterBinding postBinding = holder.binding;
        postBinding.setMovieData(arrMovies.get(position));
       postBinding.setVariable(com.android.databinding.library.baseAdapters.BR.click,onClickListener);
    }

    @android.databinding.BindingAdapter("specialTag")
    public static void setSpecialTag(android.view.View view, Object value) {
        view.setTag(value);
    }

    @Override
    public int getItemCount() {
        return arrMovies.size();
    }
    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ocean.movie.com.movieocean.databinding.RowMoviePosterBinding postBinding = android.databinding.DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_movie_poster,
                parent,
                false);
        return new BindingHolder(postBinding);
    }

    public static class BindingHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        private ocean.movie.com.movieocean.databinding.RowMoviePosterBinding binding;

        public BindingHolder(ocean.movie.com.movieocean.databinding.RowMoviePosterBinding binding) {
            super(binding.cvMoviePoster);
            this.binding = binding;

        }
    }
}

