package sauerapps.betterbetterrx.features.sharing.audioSharing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;

import sauerapps.betterbetterrx.R;
import sauerapps.betterbetterrx.app.BaseActivity;
import sauerapps.betterbetterrx.features.meditation.audioSection.AudioList;
import sauerapps.betterbetterrx.features.sharing.AddFriendActivity;
import sauerapps.betterbetterrx.model.User;
import sauerapps.betterbetterrx.utils.Constants;

/**
 * Created by andrewsauer on 3/22/16.
 */
public class ShareMainActivity extends BaseActivity {
    private static final String LOG_TAG = ShareMainActivity.class.getSimpleName();
    private FriendAudioDetailsAdapter mFriendAudioAdapter;
    private ListView mListView;
    private Firebase mSharedWithRef, mAudioDetailsListRef;
    private ValueEventListener mSharedWithListener, mAudioDetailsListListener;
    private HashMap<String, User> mSharedWithUsers;
    private AudioList mAudioList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_list);

        initializeScreen();

        Firebase currentUserFriendsRef = new Firebase(Constants.FIREBASE_URL_USER_FRIENDS).child(mEncodedEmail);

//        mSharedWithRef = new Firebase (Constants.FIREBASE_URL_AUDIO_DETAILS_SHARED_WITH).child(mEncodedEmail);

//        mSharedWithListener = mSharedWithRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                if (dataSnapshot.exists()) {
//                    mSharedWithUsers = new HashMap<String, User>();
//
//                    for (DataSnapshot currentUser : dataSnapshot.getChildren()) {
//
//                        mSharedWithUsers.put(currentUser.getKey(), currentUser.getValue(User.class));
//
//                    }
//
//                    mFriendAudioAdapter.setSharedWithUsers(mSharedWithUsers);
//
//                }
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                Log.e(LOG_TAG,
//                        getString(R.string.log_error_the_read_failed) +
//                                firebaseError.getMessage());
//            }
//        });

        mFriendAudioAdapter = new FriendAudioDetailsAdapter(ShareMainActivity.this, User.class,
                R.layout.single_user_item, currentUserFriendsRef, mEncodedEmail);

        /* Set adapter for the listView */
        mListView.setAdapter(mFriendAudioAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        /* Set adapter for the listView */
        mFriendAudioAdapter.cleanup();
//        mSharedWithRef.removeEventListener(mSharedWithListener);
    }

    public void initializeScreen() {
        mListView = (ListView) findViewById(R.id.list_view_friends_share);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        /* Add back button to the action bar */
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void onAddFriendPressed(View view) {
        Intent intent = new Intent(ShareMainActivity.this, AddFriendActivity.class);
        startActivity(intent);
    }
}