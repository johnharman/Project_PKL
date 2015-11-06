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

import com.kapanlaginetwork.johnharman.DrawerBola.KategoriBola.BolaLaLigaSpanyol;
import com.kapanlaginetwork.johnharman.DrawerBola.KategoriBola.BolaLigaChampions;
import com.kapanlaginetwork.johnharman.DrawerBola.KategoriBola.BolaLigaEropa;
import com.kapanlaginetwork.johnharman.DrawerBola.KategoriBola.BolaLigaIndonesia;
import com.kapanlaginetwork.johnharman.DrawerBola.KategoriBola.BolaLigaItaliaSeriA;
import com.kapanlaginetwork.johnharman.DrawerBola.KategoriBola.BolaLigaPremierIngrris;
import com.kapanlaginetwork.johnharman.DrawerBola.KategoriBola.BolaMostViewed;
import com.kapanlaginetwork.johnharman.DrawerBola.KategoriBola.BolaPialaDunia;
import com.kapanlaginetwork.johnharman.DrawerBola.KategoriBola.BolaTerkini;
import com.kapanlaginetwork.johnharman.DrawerBola.MenuBola.BolaBerita;
import com.kapanlaginetwork.johnharman.DrawerBola.MenuBola.BolaJadwal;
import com.kapanlaginetwork.johnharman.DrawerBola.MenuBola.BolaKlasemen;
import com.kapanlaginetwork.johnharman.DrawerBola.MenuBola.BolaSkor;
import com.kapanlaginetwork.johnharman.R;

public class Bola extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bola);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
        getMenuInflater().inflate(R.menu.bola, menu);
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

         if (id == R.id.bola_front_page) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.bola_berita) {
            startActivity(new Intent(this, BolaBerita.class));
        } else if (id == R.id.bola_jadwal) {
            startActivity(new Intent(this, BolaJadwal.class));
        } else if (id == R.id.bola_skor) {
            startActivity(new Intent(this, BolaSkor.class));
        } else if (id == R.id.bola_klasemen) {
            startActivity(new Intent(this, BolaKlasemen.class));
        } else if (id == R.id.bola_terkini) {
            startActivity(new Intent(this, BolaTerkini.class));
        } else if (id == R.id.bola_most_viewed) {
            startActivity(new Intent(this, BolaMostViewed.class));
        } else if (id == R.id.bola_liga_premier_inggris) {
            startActivity(new Intent(this, BolaLigaPremierIngrris.class));
        } else if (id == R.id.bola_liga_italia_seri_A) {
            startActivity(new Intent(this, BolaLigaItaliaSeriA.class));
        } else if (id == R.id.bola_la_liga_spanyol) {
            startActivity(new Intent(this, BolaLaLigaSpanyol.class));
        } else if (id == R.id.bola_liga_champions) {
            startActivity(new Intent(this, BolaLigaChampions.class));
         } else if (id == R.id.bola_liga_eropa) {
             startActivity(new Intent(this, BolaLigaEropa.class));
         } else if (id == R.id.bola_piala_dunia) {
             startActivity(new Intent(this, BolaPialaDunia.class));
         } else if (id == R.id.bola_liga_indonesia) {
             startActivity(new Intent(this, BolaLigaIndonesia.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
