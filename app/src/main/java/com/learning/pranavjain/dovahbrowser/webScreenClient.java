package com.learning.pranavjain.dovahbrowser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Pranav Jain on 3/29/2017.
 */

public class webScreenClient extends WebViewClient {

    @SuppressWarnings("deprecation")//to ignore deprecation related warnings
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

}
