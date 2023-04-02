package com.utkarsh.scientific.sarathi.gamepack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.utkarsh.scientific.sarathi.R;

public class GameView extends AppCompatActivity
{
    WebView gwv;
    ProgressBar progressBar;
    final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        progressBar = findViewById(R.id.progress_barGv);
        progressBar.setVisibility(View.VISIBLE);

        gwv=findViewById(R.id.GameWV);
        String url = getIntent().getExtras().getString("url");
        Toast.makeText(this, ""+url, Toast.LENGTH_SHORT).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(ProgressBar.INVISIBLE);
            }
        }, 8000);
        switch (url)
        {
            case "Mathisfun":
                url = "https://www.mathsisfun.com/puzzles/index.html";
                break;
            case "Mindgames":
                url = "https://www.mindgames.com/";
                break;
            case "Smartbrainpuzzles":
                url = "https://www.smartbrainpuzzles.com/puzzles/";
                break;
            case "Pokigames":
                url = "https://poki.com/";
                break;
            case "Fastgames":
                url="https://www.fastgames.com/";
                break;
            case "Entanglement":
                url="https://entanglement.gopherwoodstudios.com/en-US-index.html";
                break;
            case "Gridland":
                url="https://gridland.doublespeakgames.com/";
                break;
            default:
                url = "http://threesjs.com/";
                break;
        }
        gwv.loadUrl(url);
        gwv.getSettings().setJavaScriptEnabled(true);
        gwv.setWebViewClient(new WebViewClient());
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }
}