package com.secret.box.tajnide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class HomeFragment extends android.support.v4.app.Fragment {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(((MainActivity)getActivity()) != null && ((MainActivity)getActivity()).getNavigation() != null)
            ((MainActivity)getActivity()).getNavigation().getMenu().getItem(3).setChecked(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(((MainActivity)getActivity()) != null && ((MainActivity)getActivity()).getNavigation() != null)
            ((MainActivity)getActivity()).getNavigation().getMenu().getItem(3).setChecked(true);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_view, container, false);

        Animation fadeInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);

        view.findViewById(R.id.title).setAnimation(fadeInAnimation);
        view.findViewById(R.id.text1).setAnimation(fadeInAnimation);
        view.findViewById(R.id.text2).setAnimation(fadeInAnimation);
        view.findViewById(R.id.text3).setAnimation(fadeInAnimation);
        view.findViewById(R.id.text4).setAnimation(fadeInAnimation);

        view.findViewById(R.id.title).setVisibility(View.VISIBLE);
        view.findViewById(R.id.text1).setVisibility(View.VISIBLE);
        view.findViewById(R.id.text2).setVisibility(View.VISIBLE);
        view.findViewById(R.id.text3).setVisibility(View.VISIBLE);
        view.findViewById(R.id.text4).setVisibility(View.VISIBLE);

        return  view;
    }
}
