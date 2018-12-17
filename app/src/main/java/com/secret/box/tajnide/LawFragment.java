package com.secret.box.tajnide;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class LawFragment extends android.support.v4.app.Fragment {

    private ProgressDialog progressBar;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(((MainActivity)getActivity()) != null && ((MainActivity)getActivity()).getNavigation() != null)
            ((MainActivity)getActivity()).getNavigation().getMenu().getItem(1).setChecked(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(((MainActivity)getActivity()) != null && ((MainActivity)getActivity()).getNavigation() != null)
            ((MainActivity)getActivity()).getNavigation().getMenu().getItem(1).setChecked(true);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.webview, container, false);

       WebView web_view = (WebView)v.findViewById(R.id.web_view);

        progressBar = ProgressDialog.show(getActivity(), "المرسوم الملكي", "جاري التحميل ...");

        web_view.setWebViewClient(new MyBrowser());

        web_view.getSettings().setLoadsImagesAutomatically(true);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web_view.loadUrl("file:///android_asset/file.html");
        return v;

    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (progressBar.isShowing()) {
                progressBar.dismiss();
            }
        }
     }
}
