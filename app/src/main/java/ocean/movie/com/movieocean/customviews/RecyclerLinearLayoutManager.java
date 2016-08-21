package ocean.movie.com.movieocean.customviews;
/**
 * Created by naineshzaveri on 10/08/16.
 */
public class RecyclerLinearLayoutManager extends android.support.v7.widget.LinearLayoutManager {
    /**
     * Disable predictive animations. There is a bug in RecyclerView which causes views that
     * are being reloaded to pull invalid ViewHolders from the internal recycler stack if the
     * adapter size has decreased since the ViewHolder was recycled.
     */
    @Override
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public RecyclerLinearLayoutManager(android.content.Context context) {
        super(context);
    }

    public RecyclerLinearLayoutManager(android.content.Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public RecyclerLinearLayoutManager(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}