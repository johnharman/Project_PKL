package com.kapanlaginetwork.johnharman.Main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.kapanlaginetwork.johnharman.R;


public class SplashScreen extends Activity {
    ProgressBar pb;
    Intent intent;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            pb.incrementProgressBy(10);


        }


    };
    boolean isRunning = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        pb = (ProgressBar) findViewById(R.id.pbMain);
    }

    public void onStart(){
        super.onStart();
        pb.setProgress(0);

        Thread timer = new Thread(new Runnable() {

            public void run() {
                try {
                    for (int i = 0; i < 20 && isRunning; i++){
                        Thread.sleep(200);
                        handler.sendMessage(handler.obtainMessage());
                    }
                } catch (InterruptedException e) {

                    e.printStackTrace();
                } finally {
                    //activity yang akan dijalankan setelah splashscreen selesai
                    Intent i = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
        isRunning = true;
        timer.start();
    }

    public void onStop() {
        super.onStop();
        isRunning=false;
    }

}