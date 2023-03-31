package com.utkarsh.scientific.sarathi.selfHelpBooksPack;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.utkarsh.scientific.sarathi.R;

public class ViewPdf extends AppCompatActivity {

    WebView pdfWebV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        pdfWebV = (WebView) findViewById(R.id.webVPdf);

        String pUrl = getIntent().getExtras().getString("pdfUrl");
        pdfWebV.setWebViewClient(new WebViewClient());
        Toast.makeText(this, "" + pUrl, Toast.LENGTH_SHORT).show();
        pdfWebV.loadUrl(pUrl);
        WebSettings webSettings = pdfWebV.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

}