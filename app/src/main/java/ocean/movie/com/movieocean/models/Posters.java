package ocean.movie.com.movieocean.models;

/**
 * Created by naineshzaveri on 27/08/16.
 */
public class Posters extends android.databinding.BaseObservable implements java.io.Serializable {
    private String thumbnail;
    private String profile;
    private String detailed;
    private String original;

    Posters(){

    }

    @android.databinding.Bindable
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.thumbnail);
    }

    @android.databinding.BindingAdapter({"bind:imageUrl"})
    public static void loadImage(android.widget.ImageView view, String imageUrl) {
        com.squareup.picasso.Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(ocean.movie.com.movieocean.R.drawable.ic_launcher)
                .into(view);
    }

    @android.databinding.Bindable
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
        notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.profile);
    }

    @android.databinding.Bindable
    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
        notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.detailed);
    }

    @android.databinding.Bindable
    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
        notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.original);
    }
}
