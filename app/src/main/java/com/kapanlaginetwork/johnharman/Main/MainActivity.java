package com.kapanlaginetwork.johnharman.Main;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.view.KeyEvent;
import android.app.AlertDialog;
import com.kapanlaginetwork.johnharman.R;

public class MainActivity extends Activity {
    final Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Creating all buttons instances
         * */

        ImageView hdr = (ImageView) findViewById(R.id.hdr);

        TextView ftr = (TextView) findViewById(R.id.ftr);

        Button kapanlagi = (Button) findViewById(R.id.Kapanlagi);

        Button merdeka = (Button) findViewById(R.id.Merdeka);

        Button bola = (Button) findViewById(R.id.Bola);

        Button brilio = (Button) findViewById(R.id.Brilio);

        Button fimela = (Button) findViewById(R.id.Fimela);

        //Button otosia = (Button) findViewById(R.id.Otosia);

        /* Button btn_ptinggi = (Button) findViewById(R.id.btn_ptinggi);

        Button btn_tmusik = (Button) findViewById(R.id.btn_tmusik);

        Button btn_kpemerintah = (Button) findViewById(R.id.btn_kpemerintah);*/

        hdr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //--aksi jika header di click
            }
        });


        kapanlagi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Kapanlagi.class));
            }
        });

        merdeka.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Merdeka.class));
            }
        });

        bola.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Bola.class));
            }
        });

        brilio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Brilio.class));
            }
        });

        fimela.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Fimela.class);
            }
        });

        /*otosia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Otosia.class);
            }
        });*/
       /* vemale.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Vemale.class);
            }
        });

        btn_tmusik.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //--aksi tombol TM
            }
        });

        btn_kpemerintah.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //--aksi tombol KP
            }
        });*/

        ftr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //--aksi jika header di click
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("exit");
            //alertDialog.setIcon(R.drawable.appicon);

            alertDialog.setMessage("Do you really want to exit?");
            alertDialog.setButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    return;
                }
            });
            alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    return;
                }
            });
            alertDialog.show();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
/*import android.app.Activity;

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



            default:
                break;

        }

    }
}*/

