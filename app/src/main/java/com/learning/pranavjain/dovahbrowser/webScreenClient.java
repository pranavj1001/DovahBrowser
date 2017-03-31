package com.learning.pranavjain.dovahbrowser;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Pranav Jain on 3/29/2017.
 */

public class webScreenClient extends WebViewClient {

    @SuppressWarnings("deprecation")//to ignore deprecation related warnings
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        MainActivity.progressLoader.setVisibility(View.VISIBLE);
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        MainActivity.progressLoader.setVisibility(View.GONE);
    }
}
