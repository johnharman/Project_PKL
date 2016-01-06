package com.kapanlaginetwork.johnharman.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Dunia;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Gaya;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Jakarta;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Khas;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Olahraga;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Otomotif;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Peristiwa;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Politik;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Sehat;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Sepakbola;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Tegnologi;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.KategoriMerdeka.Merdeka_Uang;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.Lain2_Merdeka.Merdeka_Hak_Cipta;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.Lain2_Merdeka.Merdeka_Pengaturan;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.Lain2_Merdeka.Merdeka_Rating;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.Lain2_Merdeka.Merdeka_Tentang_Kami;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.MenuMerdeka.Merdeka_All_News;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.MenuMerdeka.Merdeka_Foto;
import com.kapanlaginetwork.johnharman.DrawerMerdeka.MenuMerdeka.Merdeka_Top_News;
import com.kapanlaginetwork.johnharman.R;

public class Merdeka extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merdeka);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.merdeka, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.merdeka_front_page) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.merdeka_all_news) {
            startActivity(new Intent(this, Merdeka_All_News.class));

        } else if (id == R.id.merdeka_top_news) {
            startActivity(new Intent(this, Merdeka_Top_News.class));

        } else if (id == R.id.merdeka_foto) {
            startActivity(new Intent(this, Merdeka_Foto.class));

        } else if (id == R.id.merdeka_peristiwa) {
            startActivity(new Intent(this, Merdeka_Peristiwa.class));

        } else if (id == R.id.merdeka_politik) {
            startActivity(new Intent(this, Merdeka_Politik.class));

        } else if (id == R.id.merdeka_jakarta) {
            startActivity(new Intent(this, Merdeka_Jakarta.class));

        } else if (id == R.id.merdeka_uang) {
            startActivity(new Intent(this, Merdeka_Uang.class));

        } else if (id == R.id.merdeka_dunia) {
            startActivity(new Intent(this, Merdeka_Dunia.class));

        } else if (id == R.id.merdeka_khas) {
            startActivity(new Intent(this, Merdeka_Khas.class));

        } else if (id == R.id.merdeka_gaya) {
            startActivity(new Intent(this, Merdeka_Gaya.class));

        } else if (id == R.id.merdeka_artis) {
            startActivity(new Intent(this, Merdeka_All_News.class));

        } else if (id == R.id.merdeka_olahraga) {
            startActivity(new Intent(this, Merdeka_Olahraga.class));

        } else if (id == R.id.merdeka_sepakbola) {
            startActivity(new Intent(this, Merdeka_Sepakbola.class));

        } else if (id == R.id.merdeka_tegnologi) {
            startActivity(new Intent(this, Merdeka_Tegnologi.class));

        } else if (id == R.id.merdeka_sehat) {
            startActivity(new Intent(this, Merdeka_Sehat.class));

        } else if (id == R.id.merdeka_otomotif) {
            startActivity(new Intent(this, Merdeka_Otomotif.class));

        } else if (id == R.id.merdeka_pengaturan) {
            startActivity(new Intent(this, Merdeka_Pengaturan.class));

        } else if (id == R.id.merdeka_rating) {
            startActivity(new Intent(this, Merdeka_Rating.class));

        } else if (id == R.id.merdeka_hak_cipta) {
            startActivity(new Intent(this, Merdeka_Hak_Cipta.class));

        } else if (id == R.id.merdeka_tentang_kami) {
            startActivity(new Intent(this, Merdeka_Tentang_Kami.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
