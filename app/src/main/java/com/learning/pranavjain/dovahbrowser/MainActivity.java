package com.learning.pranavjain.dovahbrowser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Pranav Jain on 3/25/2017.
 */

public class MainActivity extends AppCompatActivity {

    protected static WebView webScreen;
    private EditText urlContentEditText;
    private Button goToThisLinkButton, backButton, refreshButton, clearHistoryButton, forwardButton;
    protected static ProgressBar progressLoader;
    protected static RelativeLayout bottomButtonLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load all the necessary variables
        //Relative Layout
        bottomButtonLayout = (RelativeLayout) findViewById(R.id.bottomButtonLayout);
        //WebView
        webScreen = (WebView) findViewById(R.id.webScreen);
        //EditText
        urlContentEditText = (EditText) findViewById(R.id.urlContentEditText);
        //Buttons
        goToThisLinkButton = (Button) findViewById(R.id.goToThisLinkButton);
        backButton = (Button) findViewById(R.id.backButton);
        refreshButton = (Button) findViewById(R.id.refreshButton);
        clearHistoryButton = (Button) findViewById(R.id.clearHistoryButton);
        forwardButton = (Button) findViewById(R.id.forwardButton);
        //ProgressBar
        progressLoader = (ProgressBar) findViewById(R.id.progressLoader);

        //setup a webView Client
        //so that the links open in our webView only and not in another browser
        webScreen.setWebViewClient(new webScreenClient());

        //Enable JS
        final WebSettings webSettings = webScreen.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Default URL
        String defaultUrl = "https://pranavj1001.github.io";
        webScreen.loadUrl(defaultUrl);

        //When 'Go' Button is clicked
        goToThisLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEnteredUrlValue = urlContentEditText.getText().toString();
                try {
                    //URL Fixer
                    if (!(userEnteredUrlValue.isEmpty())) {
                        if (!(userEnteredUrlValue.startsWith("https://www") || userEnteredUrlValue.startsWith("http://www"))) {
                            //Log.v("URL Fixer", "no http:// found " + userEnteredUrlValue);
                            userEnteredUrlValue = "https://www." + userEnteredUrlValue;
                        } else if (userEnteredUrlValue.startsWith("www")) {
                            //Log.v("URL Fixer", "www found" + userEnteredUrlValue);
                            userEnteredUrlValue = "https://" + userEnteredUrlValue;
                        }
                        //Log.v("URL Fixer", "Load " + userEnteredUrlValue);
                        webScreen.loadUrl(userEnteredUrlValue);

                        //Create an instance of InputMethodManager
                        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        //Hide the keyboard after pressing GO button
                        inputMethodManager.hideSoftInputFromWindow(urlContentEditText.getWindowToken(), 0);

                    } else {
                        Toast.makeText(getApplicationContext(), "Please Enter the URL", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Please Enter Correct URL", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //When 'Forward' Button is clicked
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Forward", Toast.LENGTH_SHORT).show();
                if (webScreen.canGoForward()) {
                    webScreen.goForward();
                }
            }
        });

        //When 'Back' Button is clicked
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Back", Toast.LENGTH_SHORT).show();
                if (webScreen.canGoBack()) {
                    webScreen.goBack();
                }
            }
        });

        //When 'Refresh' Button is clicked
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                webScreen.reload();
            }
        });

        //When 'Clear History' Button is clicked
        clearHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Clear History", Toast.LENGTH_SHORT).show();
                webScreen.clearHistory();
            }
        });

    }
}
