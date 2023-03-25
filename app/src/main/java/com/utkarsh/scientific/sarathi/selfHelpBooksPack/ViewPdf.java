package com.utkarsh.scientific.sarathi.selfHelpBooksPack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import com.utkarsh.scientific.sarathi.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class ViewPdf extends AppCompatActivity {

    WebView pdfWebV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        pdfWebV =(WebView) findViewById(R.id.webVPdf);

        String pUrl = getIntent().getExtras().getString("pdfUrl");
        pdfWebV.setWebViewClient(new WebViewClient());
        Toast.makeText(this, ""+pUrl, Toast.LENGTH_SHORT).show();
        pdfWebV.loadUrl(pUrl);
        WebSettings webSettings=pdfWebV.getSettings();
        webSettings.setJavaScriptEnabled(true);



    }

}