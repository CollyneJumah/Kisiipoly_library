package com.library.kisiipoly;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class penaltyFrag extends Fragment {
private WebView mWebView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.frag_penalty, container, false);
        Toast.makeText(getContext(), "The penalties are mainly offenses and fine or penalties for students.", Toast.LENGTH_LONG).show();
        View v=inflater.inflate(R.layout.frag_penalty, container, false);
        mWebView = (WebView) v.findViewById(R.id.webViewPenalty);
        mWebView.loadUrl("http://kisiipoly.ac.ke/library/node/24");
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        return v;
    }
}
