package com.kapanlaginetwork.johnharman.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.kapanlaginetwork.johnharman.R;
import com.kapanlaginetwork.johnharman.model.FeedItem;

public class FeedDetailActivity extends Activity {

    private FeedItem feed;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_details);

        feed = (FeedItem) this.getIntent().getSerializableExtra("feed");

        if (null != feed) {
            ImageView thumb = (ImageView) findViewById(R.id.featuredImg);
            new ImageDownloaderTask(thumb).execute(feed.getAttachmentUrl());

            TextView title = (TextView) findViewById(R.id.title);
            title.setText(feed.getTitle());

            TextView htmlTextView = (TextView) findViewById(R.id.content);
            htmlTextView.setText(Html.fromHtml(feed.getContent(), null, null));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_share:
                shareContent();
                return true;
            case R.id.menu_view:
                Intent intent = new Intent(FeedDetailActivity.this, WebViewActivity.class);
                intent.putExtra("url", feed.getUrl());
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void shareContent() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, feed.getTitle() + "\n" + feed.getUrl());
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "Share using"));

    }
}