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

import com.kapanlaginetwork.johnharman.R;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.KapanlagiAsianStar;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.KapanlagiBollywood;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.KapanlagiFilm;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.KapanlagiHollywood;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.KapanlagiLifestyle;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.KapanlagiMusic;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.KapanlagiPlus;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.KapanlagiSelebriti;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.MenuKapanlagi.KapanlagiAllNews;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.MenuKapanlagi.KapanlagiFoto;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.MenuKapanlagi.KapanlagiTopNews;

public class Kapanlagi extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kapanlagi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

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
        getMenuInflater().inflate(R.menu.kapanlagi, menu);
        return true;
    }

   /* @Override
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
    /*@Override
   public void Kapanlagi_all_news extends Kapanlagi{

   }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.kapanlagi_front_page) {
            startActivity(new Intent(this, MainActivity.class));

     //MENU UTAMA
        } else if (id == R.id.kapanlagi_all_news) {
            startActivity(new Intent(this, KapanlagiAllNews.class));

        } else if (id == R.id.kapanlagi_top_news) {
            startActivity(new Intent(this, KapanlagiTopNews.class));

        } else if (id == R.id.kapanlagi_foto) {
            startActivity(new Intent(this, KapanlagiFoto.class));

// KATEGORI KAPANLAGI
        } else if (id == R.id.kapanlagi_selebriti) {
            startActivity(new Intent(this, KapanlagiSelebriti.class));

        } else if (id == R.id.kapanlagi_hollywood) {
            startActivity(new Intent(this, KapanlagiHollywood.class));

        } else if (id == R.id.kapanlagi_film) {
            startActivity(new Intent(this, KapanlagiFilm.class));

        } else if (id == R.id.kapanlagi_music) {
            startActivity(new Intent(this, KapanlagiMusic.class));

        } else if (id == R.id.kapanlagi_asian_star) {
            startActivity(new Intent(this, KapanlagiAsianStar.class));

        } else if (id == R.id.kapanlagi_bollywood) {
            startActivity(new Intent(this, KapanlagiBollywood.class));

        } else if (id == R.id.kapanlagi_kapanlagi_plus) {
            startActivity(new Intent(this, KapanlagiPlus.class));

        } else if (id == R.id.kapanlagi_lifestyle) {
            startActivity(new Intent(this, KapanlagiLifestyle.class));


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
