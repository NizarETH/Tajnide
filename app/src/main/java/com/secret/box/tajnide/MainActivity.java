package com.secret.box.tajnide;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;


import com.google.android.gms.ads.InterstitialAd;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {

    private DataViewModel mViewModel;
    private ActionBar toolbar;
    private RewardedVideoAd mRewardedVideoAd;
    private InterstitialAd mInterstitialAd;
    public   BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Fabric.with(this, new Crashlytics());

        toolbar = getSupportActionBar();

         navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        toolbar.setTitle("الخدمة");
        loadFragment(new WorkFragment());

        MobileAds.initialize(this, "ca-app-pub-4008954798009206~7642690726");

        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);

        loadRewardedVideoAd();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4008954798009206/6958140925");

        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice("6B15F49C17E30E253F6AD419AE6C6B0B").build());


    }

    public BottomNavigationView getNavigation() {
        return navigation;
    }

    public void setNavigation(BottomNavigationView navigation) {
        this.navigation = navigation;
    }

    @Override
    public void onPause() {
        super.onPause();
         mRewardedVideoAd.pause(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        mRewardedVideoAd.resume(this);
    }
    public void loadRewardedVideoAd() {

        if (!mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.loadAd("ca-app-pub-4008954798009206/5504322984", new AdRequest.Builder().addTestDevice("6B15F49C17E30E253F6AD419AE6C6B0B").build());

        }
    }

    public void showRewardedVideo() {
         if (mRewardedVideoAd.isLoaded()) {
             mRewardedVideoAd.show();
        }
    }

    public void loadInterstitialAd()
    {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.e("TAG", "The interstitial wasn't loaded yet.");
        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_work:
                    toolbar.setTitle("الخدمة");
                    fragment = new WorkFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_law:
                    toolbar.setTitle("القانون");
                    fragment = new LawFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_date:
                    toolbar.setTitle("التاريخ");
                    fragment = new DateFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_home:
                    toolbar.setTitle("الاعفاء");
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_contact:
                    toolbar.setTitle("اللائحة");
                    fragment = new ContactFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @Override
    public void onBackPressed() {
        int fragments = getSupportFragmentManager().getBackStackEntryCount();
        if (fragments == 1) {
            final AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("التجنيد الاجباري");

            b.setMessage("هل تريد اغلاق التطبيق ؟");
            b.setCancelable(false)
                    .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            b.show();
        } else {
            if (getFragmentManager().getBackStackEntryCount() > 1) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }
}
