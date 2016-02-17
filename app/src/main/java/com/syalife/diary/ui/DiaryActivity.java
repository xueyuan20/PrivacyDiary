package com.syalife.diary.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.syalife.diary.R;
import com.syalife.diary.adapter.ContentListAdapter;
import com.syalife.diary.object.ContentItem;
import com.syalife.library.util.SYA_LOG;
import com.umeng.analytics.MobclickAgent;

public class DiaryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView mContentList;
    private ContentListAdapter mContentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Floating action button.
         */
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

        /**
         * Initialize test data.
         */
        mContentList = (ListView) findViewById(R.id.list);
        mContentListAdapter = new ContentListAdapter(this);
        mContentList.setAdapter(mContentListAdapter);

        freshContent(mContentListAdapter);
    }

    private void freshContent(ContentListAdapter listAdapter) {
        SYA_LOG.i("freshContent....");
        if (listAdapter == null) {
            return;
        }
        listAdapter.clear();
        for (int i = 0; i < 20; i++) {
            ContentItem item = new ContentItem(i, "[Test]" + String.valueOf(i + 1), "test");
            listAdapter.add(item);
        }
        listAdapter.notifyDataSetChanged();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_video) {

        } else if (id == R.id.nav_achievement) {

        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_circle) {

        } else if (id == R.id.nav_settings) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

}
