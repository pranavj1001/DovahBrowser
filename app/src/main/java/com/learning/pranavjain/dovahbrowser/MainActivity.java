package com.learning.pranavjain.dovahbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webScreen = (WebView) findViewById(R.id.webScreen);

        String url = "https://pranavj1001.github.io";

        webScreen.loadUrl(url);

    }
}
