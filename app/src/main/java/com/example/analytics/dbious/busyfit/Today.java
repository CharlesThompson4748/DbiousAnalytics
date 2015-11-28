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

        DatabaseHandler db = new DatabaseHandler(this);
        //RemoteDatabaseHandler remoteDb = new RemoteDatabaseHandler("BusyFitUser");

        final List<WorkoutSchedule> entries = db.getAllWorkoutScheduleEntries();
        final ArrayList<String> theList = new ArrayList<String>();
        final ArrayList<String> descriptionList = new ArrayList<String>();

        for (int i = 0; i < entries.size(); i++) {
            theList.add(entries.get(i).getName());
            descriptionList.add(entries.get(i).getDesc());
        }
        theList.add("some thing else");
        theList.add("some thing else2");
        theList.add("some thing else3");
        theList.add("some thing else4");
        theList.add("some thing else5");

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theList);

        final ListView theListView = (ListView) findViewById(R.id.workout_list);

        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> theAdapter, View v,
                                    int index, long id) {
                Toast.makeText(getApplicationContext(), descriptionList.get(index), Toast.LENGTH_LONG).show();
            }
        });

    }
}

