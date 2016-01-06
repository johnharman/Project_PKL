package com.kapanlaginetwork.johnharman.Main;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kapanlaginetwork.johnharman.R;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.Kapanlagi_Asian_Star;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.Kapanlagi_Bollywood;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.Kapanlagi_Film;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.Kapanlagi_Hollywood;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.Kapanlagi_Lifestyle;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.Kapanlagi_Music;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.Kapanlagi_Plus;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.KategoriKapanlagi.Kapanlagi_Selebriti;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.MenuKapanlagi.Kapanlagi_All_News;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.MenuKapanlagi.Kapanlagi_Foto;
import com.kapanlaginetwork.johnharman.DrawerKapanlagi.MenuKapanlagi.Kapanlagi_Top_News;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class Kapanlagi extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<rFeedItem> feedList = null;
    private ProgressBar progressbar = null;
    private ListView feedListView = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kapanlagi);

        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        //feedList = new ArrayList<rFeedItem>();
        String url = "http://apps.bola.net/api/magang/?category=liga%20spanyol&page=2&limit=2";
        new DownloadFilesTask().execute(url);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//reader


    }

    public void updateList() {
        feedListView= (ListView) findViewById(R.id.custom_list);
        feedListView.setVisibility(View.VISIBLE);
        progressbar.setVisibility(View.GONE);

        feedListView.setAdapter(new rCustomListAdapter(this, feedList));
        feedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = feedListView.getItemAtPosition(position);
                rFeedItem newsData = (rFeedItem) o;

                Intent intent = new Intent(Kapanlagi.this, rFeedDetailsActivity.class);
                intent.putExtra("feed", newsData);
                startActivity(intent);
            }
        });
    }

    private class DownloadFilesTask extends AsyncTask<String, Integer, Void> {

     /* ProgressDialog dialog;

       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           dialog = new ProgressDialog(Kapanlagi.this);
           dialog.setMessage("Loading, please wait");
           dialog.setTitle("Connecting server");
           dialog.show();
           dialog.setCancelable(false);
       }*/

        @Override
        protected void onPostExecute(Void result) {
            if (null != feedList) {
                updateList();
            }
        }

        @Override
        protected Void doInBackground(String... params) {
            String url = params[0];

            // getting JSON string from URL
            JSONObject json = getJSONFromUrl(url);

            //parsing json data
            parseJson(json);
            return null;
        }
    }


    public JSONObject getJSONFromUrl(String url) {
        InputStream is = null;
        JSONObject jObj = null;
        String json = null;

        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line); // + "\n");
            }
            is.close();
            json = sb.toString();
            json = json.replace("[[", "");
            json = json.replace("]]", "");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String
        return jObj;

    }

    public void parseJson(JSONObject json) {
        try {
            rFeedItem item = new rFeedItem();
            item.setIdnews(json.getString("idnews"));
            Log.i("test", json.getString("idnews"));

            item.setTitle(json.getString("title"));
            Log.i("test", json.getString("title"));

            item.setSynopsis(json.getString("synopsis"));
            Log.i("test", json.getString("synopsis"));

            item.setSchedule(json.getString("schedule"));
            Log.i("test", json.getString("schedule"));

            item.setUrl(json.getString("url"));
            Log.i("test", json.getString("url"));

            feedList = new ArrayList<rFeedItem>();
            feedList.add(item);

/*
            // parsing json object
            if (json.getString("status").equalsIgnoreCase("ok")) {
                JSONArray posts = json.getJSONArray("posts");

                feedList = new ArrayList<rFeedItem>();

                for (int i = 0; i < posts.length(); i++) {
                    JSONObject post = (JSONObject) posts.getJSONObject(i);
                    rFeedItem item = new rFeedItem();
                    //item.setTitle(post.getString("title"));
                    //item.setDate(post.getString("date"));
                    //item.setId(post.getString("id"));
                    //item.setUrl(post.getString("url"));
                    //item.setContent(post.getString("content"));
                    item.setIdnews(post.getString("idnews"));
                    item.setTitle(post.getString("title"));
                    item.setSynopsis(post.getString("synopsis"));
                    item.setSchedule(post.getString("schedule"));
                   // item.setImageheadline(post.getString("image_headline"));
                    item.setUrl(post.getString("url"));

                    JSONArray attachments = post.getJSONArray("attachments");

                    if (null != attachments && attachments.length() > 0) {
                        JSONObject attachment = attachments.getJSONObject(0);
                        if (attachment != null)
                            item.setAttachmentUrl(attachment.getString("url"));
                    }

                    feedList.add(item);
                }
            }
            */
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.kapanlagi, menu);
        //return true;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    //reader

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.kapanlagi_front_page) {
            startActivity(new Intent(this, MainActivity.class));

            //MENU UTAMA
        } else if (id == R.id.kapanlagi_all_news) {
            startActivity(new Intent(this, Kapanlagi_All_News.class));

        } else if (id == R.id.kapanlagi_top_news) {
            startActivity(new Intent(this, Kapanlagi_Top_News.class));

        } else if (id == R.id.kapanlagi_foto) {
            startActivity(new Intent(this, Kapanlagi_Foto.class));

// KATEGORI KAPANLAGI
        } else if (id == R.id.kapanlagi_selebriti) {
            startActivity(new Intent(this, Kapanlagi_Selebriti.class));

        } else if (id == R.id.kapanlagi_hollywood) {
            startActivity(new Intent(this, Kapanlagi_Hollywood.class));

        } else if (id == R.id.kapanlagi_film) {
            startActivity(new Intent(this, Kapanlagi_Film.class));

        } else if (id == R.id.kapanlagi_music) {
            startActivity(new Intent(this, Kapanlagi_Music.class));

        } else if (id == R.id.kapanlagi_asian_star) {
            startActivity(new Intent(this, Kapanlagi_Asian_Star.class));

        } else if (id == R.id.kapanlagi_bollywood) {
            startActivity(new Intent(this, Kapanlagi_Bollywood.class));

        } else if (id == R.id.kapanlagi_kapanlagi_plus) {
            startActivity(new Intent(this, Kapanlagi_Plus.class));

        } else if (id == R.id.kapanlagi_lifestyle) {
            startActivity(new Intent(this, Kapanlagi_Lifestyle.class));


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}


