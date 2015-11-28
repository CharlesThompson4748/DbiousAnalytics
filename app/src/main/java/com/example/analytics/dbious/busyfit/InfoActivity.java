package com.example.analytics.dbious.busyfit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by charlie on 11/24/2015.
 */
public class InfoActivity extends AppCompatActivity {
    private DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);

        List workoutList = dbHandler.getAllWorkoutScheduleEntries();
        // Simple array with a list of my favorite TV shows
//        String[] favoriteTVShows = {"Futurama", "Better Off Ted",
//                "Twin Peaks", "Freaks and Geeks", "Orphan Black", "Walking Dead",
//                "Breaking Bad", "The 400", "Alphas", "Life on Mars"};

        ListAdapter theAdapter = new ArrayAdapter<List>(this, android.R.layout.simple_list_item_1, workoutList);

        ListView theListView = (ListView) findViewById(R.id.workout_list);

        theListView.setAdapter(theAdapter);
    }
}