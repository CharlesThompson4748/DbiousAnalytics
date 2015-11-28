package com.example.analytics.dbious.busyfit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Today extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_activity);

        // Simple array with a list of my favorite TV shows
        String[] favoriteTVShows = {"Pushing Daisies", "Better Off Ted",
                "Twin Peaks", "Freaks and Geeks", "Orphan Black", "Walking Dead",
                "Breaking Bad", "The 400", "Alphas", "Life on Mars"};

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, favoriteTVShows);

        ListView theListView = (ListView) findViewById(R.id.workout_list);

        theListView.setAdapter(theAdapter);

        //theListView.setOnItemClickListener(new AdapterView);
        //ArrayList<String> workoutList = new ArrayList<>();
        //workoutList.addAll(Arrays.asList(favoriteTVShows));

        //MyAdapter workoutListAdapter = (MyAdapter) new ArrayAdapter<>(this, R.layout.workout_list,
        //        R.id.workout_list_item, workoutList);

        //ListView theListView = (ListView) findViewById(R.id.workout_list);

        //theListView.setAdapter(workoutListAdapter);
    }
}

