package com.example.analytics.dbious.busyfit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Today extends AppCompatActivity {
    private DatabaseHandler dbHandler;
    private List<String> workoutList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_activity);

        //workoutList = dbHandler.getAllWorkoutScheduleEntries();
        //workoutList.add("an item1");
        //workoutList.add("an item2");
        //workoutList.add("an item3");
        //workoutList.add("an item4");
        //ArrayList<String> workoutNames = new ArrayList(workoutList.size());

        //for (int i = 0; i < workoutList.size(); i++){
        //    workoutNames.set(i, workoutList.get(i).getName());
        //}
        // Simple array with a list of my favorite TV shows
        //String[] favoriteTVShows = (String[]) workoutNames.toArray();

        //ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, workoutList);

        //ListView theListView = (ListView) findViewById(R.id.workout_list);

        //theListView.setAdapter(theAdapter);

        //theListView.setOnItemClickListener(new AdapterView);
        //ArrayList<String> workoutList = new ArrayList<>();
        //workoutList.addAll(Arrays.asList(favoriteTVShows));

        //MyAdapter workoutListAdapter = (MyAdapter) new ArrayAdapter<>(this, R.layout.workout_list,
        //        R.id.workout_list_item, workoutList);

        //ListView theListView = (ListView) findViewById(R.id.workout_list);

        //theListView.setAdapter(workoutListAdapter);
    }
}

