package com.example.analytics.dbious.busyfit;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
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
        // Start Database handler, create a list with data from database, make an arrayList from it.
        DatabaseHandler db = new DatabaseHandler(this);
        //RemoteDatabaseHandler remoteDb = new RemoteDatabaseHandler("BusyFitUser");

        List<WorkoutSchedule> entries = db.getAllWorkoutScheduleEntries();
        ArrayList<String> theList = new ArrayList<String>();

        for (int iter = 0; iter < entries.size(); iter++) {
            theList.add(entries.get(iter).getName());
        }

        //The following uses the due_workouts_list.xml file to adapt the data from the map (TheList) into the ListView
        //SimpleAdapter adapter = new SimpleAdapter(this, theList, R.layout.workout_list);
        //entriesListView.setAdapter(adapter);

        //entriesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

//            public boolean onItemLongClick(AdapterView<?> adapter, View v,
//                                           int index, long id) {
//                //final TextView entriesLV = (TextView) v.findViewById(R.id.dueWorkouts);
//                //final String test = entriesLV.getText().toString();
//                //String val = c.getString(c.getColumnIndex("COLUMN_ID"));
//                Toast.makeText(Overview.this, entriesListView.getItemAtPosition(index).toString(), Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theList);

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


    public void watchYoutubeVideo(String id){
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
            startActivity(intent);
        }catch (ActivityNotFoundException ex){
            Intent intent=new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v="+id));
            startActivity(intent);
        }
    }
}

