package yass.tawakadziruni.com.myboyremake;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;


public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    private AdView mAdView;
    private ProgressBar spinner;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, "ca-app-pub-7738678049484474/7168229263");
        mAdView = (AdView) findViewById(R.id.adView);
        final AdRequest adRequest = new AdRequest.Builder().build();


        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        spinner = (ProgressBar) findViewById(R.id.progressBar1);

        final ArrayList<Photo> Pics = new ArrayList<>();
        final Button AddPhotoButton = (Button) findViewById(R.id.button);

        final PhotoAdapter adapter = new PhotoAdapter(this, Pics);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        Pics.add(new Photo(getDrawable(R.drawable.images)));
        Pics.add(new Photo(getDrawable(R.drawable.wowo)));
        Pics.add(new Photo(getDrawable(R.drawable.card_view_san_fran)));
        Pics.add(new Photo(getDrawable(R.drawable.download)));
        Pics.add(new Photo(getDrawable(R.drawable.images)));
        Pics.add(new Photo(getDrawable(R.drawable.san2)));
        Pics.add(new Photo(getDrawable(R.drawable.san)));

        spinner.setVisibility(View.GONE);
        AddPhotoButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                AddPhotoButton.startAnimation(anim1);
                mAdView.loadAd(adRequest);

                while (mAdView.isLoading()) {
                    spinner.setVisibility(View.VISIBLE);
                }
                if (mAdView.isShown()) {
                    anim1.cancel();
                }

                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "Add Photo button.");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Add Photo button..");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Button");
                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

            }
        });


    }
}

//// TODO: 2017/08/20 Find a way of retrieving the photo.







