package com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kapanlaginetwork.johnharman.R;
import com.kapanlaginetwork.johnharman.Main.rFeedItem;

public class Kapanlagi_Asian_Star extends AppCompatActivity {
    private rFeedItem feed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kategori_kapanlagi);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}