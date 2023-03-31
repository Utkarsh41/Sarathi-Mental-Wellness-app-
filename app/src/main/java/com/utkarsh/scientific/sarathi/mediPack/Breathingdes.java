package com.utkarsh.scientific.sarathi.mediPack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.utkarsh.scientific.sarathi.R;

public class Breathingdes extends AppCompatActivity {

    private TextView br,descript,how,howd,repeat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathingdes);

        br=(TextView) findViewById(R.id.head);
        descript=(TextView) findViewById(R.id.descript);
        how=(TextView) findViewById(R.id.how);
        howd=(TextView) findViewById(R.id.howd);
        repeat=(TextView) findViewById(R.id.cautiond);


        String asnName = getIntent().getExtras().getString("AssanName");

        Toast.makeText(this, ""+asnName, Toast.LENGTH_SHORT).show();
//        br.setText(asnName);
        if (asnName.equals("Alternate nostril breathing")) {
            br.setText(getResources().getString(R.string.AltNosB));
            descript.setText(getResources().getString(R.string.AltNosBD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.AltNosBH));
            repeat.setText(getResources().getString(R.string.AltNosBT));
        }
        else if (asnName.equals("Belly breathing")) {
            br.setText(getResources().getString(R.string.BellyB));
            descript.setText(getResources().getString(R.string.BellyBD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.BellyBH));
            repeat.setText(getResources().getString(R.string.BellyBT));
        }
        else if (asnName.equals("Box breathing")) {
            br.setText(getResources().getString(R.string.BoxB));
            descript.setText(getResources().getString(R.string.BoxBD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.BoxBH));
            repeat.setText(getResources().getString(R.string.BoxBT));
        }
        else if (asnName.equals("4-7-8 Breathing")) {
            br.setText(getResources().getString(R.string.B487));
            descript.setText(getResources().getString(R.string.B487D));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.B487H));
            repeat.setText(getResources().getString(R.string.B487T));
        }
        else if (asnName.equals("Lion breath")) {
            br.setText(getResources().getString(R.string.LionB));
            descript.setText(getResources().getString(R.string.LionBD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.LionBH));
            repeat.setText(getResources().getString(R.string.LionBT));
        }
        else if (asnName.equals("Mindfulness\nbreathing")) {
            br.setText(getResources().getString(R.string.MindB));
            descript.setText(getResources().getString(R.string.MindBD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.MindBH));
            repeat.setText(getResources().getString(R.string.MindBT));
        }
        else if (asnName.equals("Pursed-lip\nbreathing")) {
            br.setText(getResources().getString(R.string.PurseB));
            descript.setText(getResources().getString(R.string.PurseBD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.PurseBH));
            repeat.setText(getResources().getString(R.string.PurseBT));
        }
        else if (asnName.equals("Resonance\nbreathing")) {
            br.setText(getResources().getString(R.string.ResonanceB));
            descript.setText(getResources().getString(R.string.ResonanceBD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.ResonanceBH));
            repeat.setText(getResources().getString(R.string.ResonanceBT));
        }

    }
}