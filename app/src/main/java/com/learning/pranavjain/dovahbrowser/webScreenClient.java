package com.learning.pranavjain.dovahbrowser;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Pranav Jain on 3/29/2017.
 */

public class webScreenClient extends WebViewClient {

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        MainActivity.progressLoader.setVisibility(View.VISIBLE);
    }

    @SuppressWarnings("deprecation")//to ignore deprecation related warnings
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        MainActivity.progressLoader.setVisibility(View.GONE);
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        Log.v("Error!", error.toString());
        if (MainActivity.webScreen.canGoBack()) {
            MainActivity.webScreen.goBack();
        } else {
            MainActivity.webScreen.loadUrl("https://pranavj1001.github.io");
        }
    }
}
