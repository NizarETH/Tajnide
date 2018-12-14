package com.secret.box.tajnide;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class WorkFragment extends android.support.v4.app.Fragment {

    private View view;

    private ViewPager mViewPager;
    private LinearLayout container;

    private TextView[] dots;
    private LinearLayout dotsLayout;
    private int[] layouts = {0,0,0,0,0,0,0,0,0,0,0};
    private List<ElementSwipe> elementSwipes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.swipper_center_top_layout_smart, container, false);

        dotsLayout = (LinearLayout) view.findViewById(R.id.layoutDots);



        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        addBottomDots(0);

        ElementSwipe e1  = new ElementSwipe(getResources().getDrawable(R.drawable.img2));
        ElementSwipe e2  = new ElementSwipe(getResources().getDrawable(R.drawable.img3));
        ElementSwipe e3  = new ElementSwipe(getResources().getDrawable(R.drawable.img4));
        ElementSwipe e4  = new ElementSwipe(getResources().getDrawable(R.drawable.img5));
        ElementSwipe e5  = new ElementSwipe(getResources().getDrawable(R.drawable.img6));
        ElementSwipe e6  = new ElementSwipe(getResources().getDrawable(R.drawable.img7));
        ElementSwipe e7  = new ElementSwipe(getResources().getDrawable(R.drawable.img8));
        ElementSwipe e8  = new ElementSwipe(getResources().getDrawable(R.drawable.img9));
        ElementSwipe e9  = new ElementSwipe(getResources().getDrawable(R.drawable.img10));
        ElementSwipe e10  = new ElementSwipe(getResources().getDrawable(R.drawable.img11));
        ElementSwipe e11  = new ElementSwipe(getResources().getDrawable(R.drawable.img12));

        elementSwipes = new ArrayList<>();

            elementSwipes.add(e1);
            elementSwipes.add(e2);
            elementSwipes.add(e3);
            elementSwipes.add(e4);
            elementSwipes.add(e5);
            elementSwipes.add(e6);
            elementSwipes.add(e7);
            elementSwipes.add(e8);
            elementSwipes.add(e9);
            elementSwipes.add(e10);
            elementSwipes.add(e11);

        final DashBoardAdapter dashBoardAdapter = new DashBoardAdapter((MainActivity)getActivity(), elementSwipes);
        mViewPager.setAdapter(dashBoardAdapter);
        mViewPager.addOnPageChangeListener(viewPagerPageChangeListener);





        return  view;
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];


        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {

            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.WHITE);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.DKGRAY);
    }
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {


        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }




}

