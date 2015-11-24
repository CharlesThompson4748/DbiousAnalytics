package com.example.analytics.dbious.busyfit;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import java.util.logging.Handler;

/**
 * Created by charlie on 11/24/2015.
 */
public class TabLayout extends TabActivity {
    private TabHost mTabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

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

        mTabHost.setCurrentTab(1);
    }
}
