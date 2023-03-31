package com.utkarsh.scientific.sarathi.mediPack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.utkarsh.scientific.sarathi.R;

public class Yogades extends AppCompatActivity {

    private TextView yog,descript,how,howd,caution,cautiond;
    private ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yogades);

        yog=(TextView) findViewById(R.id.head);
        descript=(TextView) findViewById(R.id.descript);
        how=(TextView) findViewById(R.id.how);
        howd=(TextView) findViewById(R.id.howd);
        caution=(TextView) findViewById(R.id.caution);
        cautiond=(TextView) findViewById(R.id.cautiond);
        im=(ImageView)findViewById(R.id.detailBrIv);

        String asnName = getIntent().getExtras().getString("AssanName");

        Toast.makeText(this, ""+asnName, Toast.LENGTH_SHORT).show();
        yog.setText(asnName);
        if (asnName.equals("Virabhadrasana")) {
            im.setBackgroundResource(R.drawable.virabhadrasana);
            yog.setText(getResources().getString(R.string.Virabhadrasana));
            descript.setText(getResources().getString(R.string.VirabhadrasanaD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.VirbhadrasanaH));
            caution.setText(getResources().getString(R.string.caution));
            cautiond.setText(getResources().getString(R.string.VirbhadrasanaC));
        }
        else if (asnName.equals("Natarajasana")) {
            im.setBackgroundResource(R.drawable.natarajasana);
            yog.setText(getResources().getString(R.string.Natarajasana));
            descript.setText(getResources().getString(R.string.NatarajasanaD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.NatarajasanaH));
            caution.setText(getResources().getString(R.string.caution));
            cautiond.setText(getResources().getString(R.string.NatarajasanaC));
        }
        else if (asnName.equals("Vriksasana")) {
            im.setBackgroundResource(R.drawable.vriksasana);
            yog.setText(getResources().getString(R.string.Vriksasana));
            descript.setText(getResources().getString(R.string.VriksasanaD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.VriksasanaH));
            caution.setText(getResources().getString(R.string.caution));
            cautiond.setText(getResources().getString(R.string.VriksasanaC));
        }
        else if (asnName.equals("Anjaneyasana")) {
            im.setBackgroundResource(R.drawable.anjaneyasana);
            yog.setText(getResources().getString(R.string.Anjaneyasana));
            descript.setText(getResources().getString(R.string.AnjaneyasanaD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.AnjaneyasanaH));
            caution.setText(getResources().getString(R.string.caution));
            cautiond.setText(getResources().getString(R.string.AnjaneyasanaC));
        }
        else if (asnName.equals("Garudasana")) {
            im.setBackgroundResource(R.drawable.garudasana);
            yog.setText(getResources().getString(R.string.Garudasana));
            descript.setText(getResources().getString(R.string.GarudasanaD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.GarudasanaH));
            caution.setText(getResources().getString(R.string.caution));
            cautiond.setText(getResources().getString(R.string.GarudasanaC));
        }
        else if (asnName.equals("Adho Mukha Vrksasana")) {
            im.setBackgroundResource(R.drawable.handstand);
            yog.setText(getResources().getString(R.string.AdhoMukhaVrksasana));
            descript.setText(getResources().getString(R.string.AdhoMukhaVrksasanaD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.AdhoMukhaVrksasanaH));
            caution.setText(getResources().getString(R.string.caution));
            cautiond.setText(getResources().getString(R.string.AdhoMukhaVrksasanaC));
        }
        else if (asnName.equals("Chakrasana")) {
            im.setBackgroundResource(R.drawable.chakrasana);
            yog.setText(getResources().getString(R.string.Chakrasana));
            descript.setText(getResources().getString(R.string.ChakrasanaD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.ChakrasanaH));
            caution.setText(getResources().getString(R.string.caution));
            cautiond.setText(getResources().getString(R.string.ChakrasanaC));
        }
        else if (asnName.equals("Vajrasana")) {
            im.setBackgroundResource(R.drawable.vajrasana);
            yog.setText(getResources().getString(R.string.Vajrasana));
            descript.setText(getResources().getString(R.string.VajrasanaD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.VajrasanaH));
            caution.setText(getResources().getString(R.string.caution));
            cautiond.setText(getResources().getString(R.string.VajrasanaC));
        }
        else if (asnName.equals("Padmasana")) {
            im.setBackgroundResource(R.drawable.padmasana);
            yog.setText(getResources().getString(R.string.Padmasana));
            descript.setText(getResources().getString(R.string.PadmasanaD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.PadmasanaH));
            caution.setText(getResources().getString(R.string.caution));
            cautiond.setText(getResources().getString(R.string.PadmasanaC));
        }
        else if (asnName.equals("Savasana")) {
            im.setBackgroundResource(R.drawable.corpse);
            yog.setText(getResources().getString(R.string.Savasana));
            descript.setText(getResources().getString(R.string.SavasanaD));
            how.setText(getResources().getString(R.string.How));
            howd.setText(getResources().getString(R.string.SavasanaH));
            caution.setText(getResources().getString(R.string.caution));
            cautiond.setText(getResources().getString(R.string.SavasanaC));
        }


    }

}