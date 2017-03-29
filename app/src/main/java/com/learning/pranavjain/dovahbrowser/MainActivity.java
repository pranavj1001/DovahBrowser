package com.learning.pranavjain.dovahbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private WebView webScreen;
    private EditText urlContentEditText;
    private Button goToThisLinkButton, backButton, refreshButton, stopButton, forwardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webScreen = (WebView) findViewById(R.id.webScreen);
        urlContentEditText = (EditText) findViewById(R.id.urlContentEditText);
        goToThisLinkButton = (Button) findViewById(R.id.goToThisLinkButton);
        backButton = (Button) findViewById(R.id.backButton);
        refreshButton = (Button) findViewById(R.id.refreshButton);
        stopButton = (Button) findViewById(R.id.stopButton);
        forwardButton = (Button) findViewById(R.id.forwardButton);

        goToThisLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEnterredUrlValue = urlContentEditText.getText().toString();
                try{
                    if (!(userEnterredUrlValue.isEmpty())) {
                        webScreen.loadUrl(userEnterredUrlValue);
                    }else {
                        Toast.makeText(getApplicationContext(), "Please Enter the URL", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Please Enter Correct URL", Toast.LENGTH_SHORT).show();
                }
            }
        });

        String defaultUrl = "https://pranavj1001.github.io";
        webScreen.loadUrl(defaultUrl);

    }
}
