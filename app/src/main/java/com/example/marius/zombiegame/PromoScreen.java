package com.example.marius.zombiegame;

/**
 * Created by Mariu on 2/8/2018.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

public class PromoScreen extends AppCompatActivity
        implements View.OnClickListener {

    private final String TAG = "FB_PROMO";
    private FirebaseAnalytics mFBAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_screen);

        // TODO: Get a reference to Firebase analytics
        mFBAnalytics=FirebaseAnalytics.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // TODO: Record the user's view of this Activity as a VIEW_ITEM
        // analytics event, which is provided by Firebase
        Bundle params = new Bundle();
        params.putString(FirebaseAnalytics.Param.ITEM_ID, "Promo Item");
        mFBAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, params);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBuyNow) {
            // TODO: Record a click on the Buy button as an ECOMMERCE_PURCHASE
            // Firebase analytics event
            Bundle params = new Bundle();
            params.putString(FirebaseAnalytics.Param.ITEM_ID, "Promo Item");
            mFBAnalytics.logEvent(FirebaseAnalytics.Event
                    .ECOMMERCE_PURCHASE, params);

        }
    }
}

