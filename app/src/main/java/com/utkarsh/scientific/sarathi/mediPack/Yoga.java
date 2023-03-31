package com.utkarsh.scientific.sarathi.mediPack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.utkarsh.scientific.sarathi.R;

public class Yoga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        CardView yoga1,yoga2,yoga3,yoga4,yoga5,yoga6,yoga7,yoga8,yoga9,yoga10;
        TextView yogaTv1,yogaTv2,yogaTv3,yogaTv4,yogaTv5,yogaTv6,yogaTv7,yogaTv8,yogaTv9,yogaTv10;
        yogaTv1 = findViewById(R.id.Yoga1);
        yogaTv2 = findViewById(R.id.Yoga2);
        yogaTv3 = findViewById(R.id.Yoga3);
        yogaTv4 = findViewById(R.id.Yoga4);
        yogaTv5 = findViewById(R.id.Yoga5);
        yogaTv6 = findViewById(R.id.Yoga6);
        yogaTv7 = findViewById(R.id.Yoga7);
        yogaTv8 = findViewById(R.id.Yoga8);
        yogaTv9 = findViewById(R.id.Yoga9);
        yogaTv10 = findViewById(R.id.Yoga10);

        yoga1=findViewById(R.id.Yogacd1);
        yoga2=findViewById(R.id.Yogacd2);
        yoga3=findViewById(R.id.Yogacd3);
        yoga4=findViewById(R.id.Yogacd4);
        yoga5=findViewById(R.id.Yogacd5);
        yoga6=findViewById(R.id.Yogacd6);
        yoga7=findViewById(R.id.Yogacd7);
        yoga8=findViewById(R.id.Yogacd8);
        yoga9=findViewById(R.id.Yogacd9);
        yoga10=findViewById(R.id.Yogacd10);


        yoga1.setOnClickListener(view -> {
            Intent i=new Intent(Yoga.this,Yogades.class);
            String temp = (String) yogaTv1.getText();
            i.putExtra("AssanName",temp);
//            Log.d("Chk",yogaTv.getText().toString());
            startActivity(i);
        });

        yoga2.setOnClickListener(view -> {
            Intent i=new Intent(Yoga.this,Yogades.class);
            String temp = (String) yogaTv2.getText();
            i.putExtra("AssanName", temp);
            startActivity(i);
        });

        yoga3.setOnClickListener(view -> {
            Intent i=new Intent(Yoga.this,Yogades.class);
            String temp = (String) yogaTv3.getText();
            i.putExtra("AssanName", temp);
            startActivity(i);
        });

        yoga4.setOnClickListener(view -> {
            Intent i=new Intent(Yoga.this,Yogades.class);
            String temp = (String) yogaTv4.getText();
            i.putExtra("AssanName", temp);
            startActivity(i);
        });

        yoga5.setOnClickListener(view -> {
            Intent i=new Intent(Yoga.this,Yogades.class);
            String temp = (String) yogaTv5.getText();
            i.putExtra("AssanName", temp);
            startActivity(i);
        });

        yoga6.setOnClickListener(view -> {
            Intent i=new Intent(Yoga.this,Yogades.class);
            String temp = (String) yogaTv6.getText();
            i.putExtra("AssanName", temp);
            startActivity(i);
        });

        yoga7.setOnClickListener(view -> {
            Intent i=new Intent(Yoga.this,Yogades.class);
            String temp = (String) yogaTv7.getText();
            i.putExtra("AssanName", temp);
            startActivity(i);
        });

        yoga8.setOnClickListener(view -> {
            Intent i=new Intent(Yoga.this,Yogades.class);
            String temp = (String) yogaTv8.getText();
            i.putExtra("AssanName", temp);
            startActivity(i);
        });

        yoga9.setOnClickListener(view -> {
            Intent i=new Intent(Yoga.this,Yogades.class);
            String temp = (String) yogaTv9.getText();
            i.putExtra("AssanName", temp);
            startActivity(i);
        });

        yoga10.setOnClickListener(view -> {
            Intent i=new Intent(Yoga.this,Yogades.class);
            String temp = (String) yogaTv10.getText();
            i.putExtra("AssanName", temp);
            startActivity(i);
        });

    }
}