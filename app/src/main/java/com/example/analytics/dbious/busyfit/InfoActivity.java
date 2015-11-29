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

<<<<<<< HEAD
        // Simple array with a list of my favorite TV shows
        String[] favoriteTVShows = {"Futurama", "Better Off Ted",
                "Twin Peaks", "Freaks and Geeks", "Orphan Black", "Walking Dead",
                "Breaking Bad", "The 400", "Alphas", "Life on Mars"};

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, favoriteTVShows);
=======
        DatabaseHandler db = new DatabaseHandler(this);
        //RemoteDatabaseHandler remoteDb = new RemoteDatabaseHandler("BusyFitUser");
        //this will be changes to get recipes
        List<WorkoutSchedule> entries = db.getAllWorkoutScheduleEntries();
        ArrayList<String> theList = new ArrayList<String>();

        for (int i = 0; i < entries.size(); i++) {
            theList.add(entries.get(i).getName());
        }
        theList.add("some thing else");
        theList.add("some thing else2");
        theList.add("some thing else3");
        theList.add("some thing else4");
        theList.add("some thing else5");

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theList);
>>>>>>> origin/master

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