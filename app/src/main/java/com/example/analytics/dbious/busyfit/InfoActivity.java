package com.example.analytics.dbious.busyfit;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
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

        DatabaseHandler db = new DatabaseHandler(this);
        //RemoteDatabaseHandler remoteDb = new RemoteDatabaseHandler("BusyFitUser");
        //this will be changes to get recipes
        List<WorkoutSchedule> entries = db.getAllWorkoutScheduleEntries();
        ArrayList<String> theList = new ArrayList<String>();

        for (int i = 0; i < entries.size(); i++) {
            theList.add(entries.get(i).getName());
        }

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theList);

        ListView theListView = (ListView) findViewById(R.id.workout_list);

        theListView.setAdapter(theAdapter);
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