package com.secret.box.tajnide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContactِFragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.contact_view, container, false);

        v.findViewById(R.id.open_gmail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","stanly.inc.dev@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact Tajnide");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
        v.findViewById(R.id.call_pub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity() != null)
                ((MainActivity)getActivity()).  loadRewardedVideoAd();
            }
        });

        return v;
    }
}
