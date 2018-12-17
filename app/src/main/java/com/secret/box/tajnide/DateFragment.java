package com.secret.box.tajnide;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;

public class DateFragment extends android.support.v4.app.Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(((MainActivity)getActivity()) != null && ((MainActivity)getActivity()).getNavigation() != null)
            ((MainActivity)getActivity()).getNavigation().getMenu().getItem(2).setChecked(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(((MainActivity)getActivity()) != null && ((MainActivity)getActivity()).getNavigation() != null)
            ((MainActivity)getActivity()).getNavigation().getMenu().getItem(2).setChecked(true);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_view, container, false);

        Animation fadeInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);

        view.findViewById(R.id.title).setAnimation(fadeInAnimation);
        view.findViewById(R.id.text1).setAnimation(fadeInAnimation);
        view.findViewById(R.id.text2).setAnimation(fadeInAnimation);

        view.findViewById(R.id.title).setVisibility(View.VISIBLE);
        view.findViewById(R.id.text1).setVisibility(View.VISIBLE);
        view.findViewById(R.id.text2).setVisibility(View.VISIBLE);



        return  view;
    }
}
