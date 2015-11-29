package com.example.analytics.dbious.busyfit;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.app.ActionBar;

import java.util.logging.Handler;

/**
 * Created by charlie on 11/24/2015.
 */
public class TabLayout extends TabActivity {
    private TabHost mTabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        mTabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        //History tab
        intent = new Intent(this, HistoryActivity.class);
        spec = mTabHost.newTabSpec("History")
                .setIndicator("History")
                .setContent(intent);
        mTabHost.addTab(spec);

        //Today tab
        intent = new Intent(this, Today.class);
        spec = mTabHost.newTabSpec("Today")
                .setIndicator("Today")
                .setContent(intent);
        mTabHost.addTab(spec);

        //Info tab
        intent = new Intent(this, InfoActivity.class);
        spec = mTabHost.newTabSpec("Info")
                .setIndicator("Info")
                .setContent(intent);
        mTabHost.addTab(spec);
        mTabHost.setBackgroundColor(Color.parseColor("#303F9F"));
        mTabHost.setCurrentTab(1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_today, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
