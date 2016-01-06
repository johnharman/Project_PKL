package com.kapanlaginetwork.johnharman.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kapanlaginetwork.johnharman.DrawerFimela.Fimela_Beauty_Health;
import com.kapanlaginetwork.johnharman.DrawerFimela.Fimela_Fashion_Style;
import com.kapanlaginetwork.johnharman.DrawerFimela.Fimela_Lifestyle_Relationship;
import com.kapanlaginetwork.johnharman.DrawerFimela.Fimela_News_Entertainment;
import com.kapanlaginetwork.johnharman.DrawerFimela.Fimela_Travel_Shoppes;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.Kapanlagi_Plus;
import com.kapanlaginetwork.johnharman.R;

public class Fimela extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fimela);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
        getMenuInflater().inflate(R.menu.fimela, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.fimela_front_page) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.fimela_news_entertainment) {
            startActivity(new Intent(this, Fimela_News_Entertainment.class));

        } else if (id == R.id.fimela_beauty_health) {
            startActivity(new Intent(this, Fimela_Lifestyle_Relationship.class));

        } else if (id == R.id.fimela_fashion_style) {
            startActivity(new Intent(this, Fimela_Fashion_Style.class));

        } else if (id == R.id.fimela_lifestyle_relationship) {
            startActivity(new Intent(this, Fimela_Travel_Shoppes.class));

        } else if (id == R.id.fimela_travel_shoppes) {
            startActivity(new Intent(this, Fimela_Beauty_Health.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
