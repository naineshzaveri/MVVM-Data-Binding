package ocean.movie.com.movieocean.activity;

/**
 * Created by naineshzaveri on 27/08/16.
 */
public class CarouselActivity extends android.app.Activity {
    ocean.movie.com.movieocean.models.MovieModel movieModel;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBundleValues();
        ocean.movie.com.movieocean.customviews.CoverFlow coverFlow;
        coverFlow = new ocean.movie.com.movieocean.customviews.CoverFlow(this);

        coverFlow.setAdapter(new ImageAdapter(this));

        ImageAdapter coverImageAdapter =  new ImageAdapter(this);

        //coverImageAdapter.createReflectedImages();

        coverFlow.setAdapter(coverImageAdapter);

        coverFlow.setSpacing(-25);
        coverFlow.setSelection(2, true);
        coverFlow.setAnimationDuration(1000);


        setContentView(coverFlow);
    }
    private void getBundleValues(){
        movieModel = (ocean.movie.com.movieocean.models.MovieModel) getIntent().getExtras().getSerializable(ocean.movie.com.movieocean.utils.BundleKeys.KEY_MOVIE);
    }

    public class ImageAdapter extends android.widget.BaseAdapter {
        int mGalleryItemBackground;
        private android.content.Context mContext;

        private java.io.FileInputStream fis;

        private String[] mImageIds = {
                movieModel.getPosters().getThumbnail(),
                movieModel.getPosters().getDetailed(),
                movieModel.getPosters().getOriginal(),
                movieModel.getPosters().getProfile()
        };

        private android.widget.ImageView[] mImages;

        public ImageAdapter(android.content.Context c) {
            mContext = c;
            mImages = new android.widget.ImageView[mImageIds.length];
        }
        public boolean createReflectedImages() {
            //The gap we want between the reflection and the original image
            final int reflectionGap = 4;


            int index = 0;
            for (String imageId : mImageIds) {

                android.widget.ImageView imageView = new android.widget.ImageView(mContext);
                com.squareup.picasso.Picasso.with(mContext)
                        .load(imageId)
                        .placeholder(ocean.movie.com.movieocean.R.drawable.ic_launcher)
                        .into(imageView);
                imageView.setLayoutParams(new android.widget.Gallery.LayoutParams(500, 500));
                imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                mImages[index++] = imageView;

            }
            return true;
        }

        public int getCount() {
            return mImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {

            android.widget.ImageView i = new android.widget.ImageView(mContext);

            com.squareup.picasso.Picasso.with(mContext)
                    .load(mImageIds[position])
                    .placeholder(ocean.movie.com.movieocean.R.drawable.ic_launcher)
                    .into(i);
            i.setLayoutParams(new android.widget.Gallery.LayoutParams(500, 500));
            i.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);

            //Make sure we set anti-aliasing otherwise we get jaggies
            android.graphics.drawable.BitmapDrawable drawable = (android.graphics.drawable.BitmapDrawable) i.getDrawable();
            drawable.setAntiAlias(true);
            return i;

            //return mImages[position];
        }
        /** Returns the size (0.0f to 1.0f) of the views
         * depending on the 'offset' to the center. */
        public float getScale(boolean focused, int offset) {
        /* Formula: 1 / (2 ^ offset) */
            return Math.max(0, 1.0f / (float)Math.pow(2, Math.abs(offset)));
        }

    }
}
