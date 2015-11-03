package com.kapanlaginetwork.johnharman.Main;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.kapanlaginetwork.johnharman.R;


public class MainActivity extends Activity implements OnClickListener {
    //TextView txtpesan;

    ImageButton Kapanlagi;
    ImageButton Merdeka;
    ImageButton Vemale;
    ImageButton Fimela;
    ImageButton Brilio;
    ImageButton Bola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //txtpesan= (TextView) findViewById(R.id.textView1);
        //init button
        Kapanlagi = (ImageButton) findViewById(R.id.Kapanlagi);
        Merdeka = (ImageButton) findViewById(R.id.Merdeka);
        Bola = (ImageButton) findViewById(R.id.Bola);
        Brilio = (ImageButton) findViewById(R.id.Brilio);
        Fimela = (ImageButton) findViewById(R.id.Fimela);
        Vemale = (ImageButton) findViewById(R.id.Vemale);

        Kapanlagi.setOnClickListener(this);
        Merdeka.setOnClickListener(this);
        Bola.setOnClickListener(this);
        Brilio.setOnClickListener(this);
        Fimela.setOnClickListener(this);
        Vemale.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Kapanlagi:
                startActivity(new Intent(MainActivity.this, Kapanlagi.class));
                break;

            case R.id.Merdeka:
                startActivity(new Intent(MainActivity.this, Merdeka.class));
                break;

            case R.id.Bola:
                startActivity(new Intent(MainActivity.this, Bola.class));
                break;

            case R.id.Brilio:
                startActivity(new Intent(MainActivity.this, Kapanlagi.class));
                break;

            /*case R.id.Fimela:
                startActivity(new Intent(MainActivity.this, Kapanlagi.class));
                break;

            case R.id.Vemale:
                startActivity(new Intent(MainActivity.this, Kapanlagi.class));
                break;*/

            default:
                break;

        }

    }
}

