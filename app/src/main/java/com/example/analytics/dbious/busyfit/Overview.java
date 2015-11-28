package com.example.analytics.dbious.busyfit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Overview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Start Database handler, create a list with data from database, make an arrayList from it.
        DatabaseHandler db = new DatabaseHandler(this);
        RemoteDatabaseHandler remoteDb = new RemoteDatabaseHandler("BusyFitUser");

        //Testing//
        //db.createMuscleGroup(new MuscleGroup(0,"Biceps"));
        //db.createBusyFitUser(new BusyFitUser("Lee", "leecarpenter@me.com"));
        //db.createUserWorkout(new UserWorkout(0, 0));
        //db.createWorkoutSchedule(new WorkoutSchedule(0, "Test", 3, 3, 3, 0, 0, "Test Description"));
        //End test//
        List<WorkoutSchedule> entries = db.getAllWorkoutScheduleEntries();
        ArrayList<HashMap<String, String>> theList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map; // map to be used through each item in the entries list


        TextView textView = (TextView) findViewById(R.id.remoteResult);
        textView.setText("DB RESULTS");

        //The following creates a listview  , maps each column to the data
        final ListView entriesListView = (ListView) this.findViewById(R.id.dueWorkouts);

        for (int i = 0; i < entries.size(); i++) {
            map = new HashMap<String, String>();

            map.put("COLUMN_NAME", entries.get(i).getName());
            map.put("COLUMN_DESC", entries.get(i).getDesc());
            map.put("COLUMN_FREQ", Integer.toString(entries.get(i).getHourPart()));
            map.put("COLUMN_ID", Integer.toString(entries.get(i).getId()));
            theList.add(map);
        }
        //USED TO TEST LISTVIEW CAPABILITY W/O DATABASE//
        /*map = new HashMap<String, String>();
        map.put("COLUMN_NAME", "TestName");
        map.put("COLUMN_DESC", "This is a short description");
        map.put("COLUMN_FREQ", "4");
        map.put("COLUMN_ID", "0");
        theList.add(map);*/

        //The following uses the due_workouts_list.xml file to adapt the data from the map (TheList) into the ListView
         SimpleAdapter adapter = new SimpleAdapter(this, theList, R.layout.due_workouts_list,
                new String[] { "COLUMN_DATE", "COLUMN_DISTANCE", "COLUMN_NOTES", "COLUMN_ID" }, new int[] {
               R.id.COLUMN_NAME, R.id.COLUMN_DESC, R.id.COLUMN_FREQ, R.id.COLUMN_ID});
            entriesListView.setAdapter(adapter);

        entriesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> adapter, View v,
                                           int index, long id) {
                //final TextView entriesLV = (TextView) v.findViewById(R.id.dueWorkouts);
                //final String test = entriesLV.getText().toString();
                //String val = c.getString(c.getColumnIndex("COLUMN_ID"));
                Toast.makeText(Overview.this, entriesListView.getItemAtPosition(index).toString(), Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
