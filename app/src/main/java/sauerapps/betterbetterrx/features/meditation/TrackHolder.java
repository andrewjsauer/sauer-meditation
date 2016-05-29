package sauerapps.betterbetterrx.features.meditation;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sauerapps.betterbetterrx.R;

public class TrackHolder extends RecyclerView.ViewHolder {
    ImageView mTrackImageView;
    TextView mTitleTextView;
    CardView mCardView;
    TextView mTitleDescription;

    public TrackHolder(View itemView) {
        super(itemView);
        mTrackImageView = (ImageView) itemView.findViewById(R.id.track_image);
        mTitleTextView = (TextView) itemView.findViewById(R.id.track_title);
        mTitleDescription = (TextView) itemView.findViewById(R.id.track_description);
        mCardView = (CardView) itemView.findViewById(R.id.cv);
    }
}
