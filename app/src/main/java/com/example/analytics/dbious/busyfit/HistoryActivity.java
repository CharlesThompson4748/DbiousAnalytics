package com.example.analytics.dbious.busyfit;

import android.content.ActivityNotFoundException;
import android.content.Context;
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
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charlie on 11/24/2015.
 */
public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);
        DatabaseHandler db = new DatabaseHandler(this);
        //RemoteDatabaseHandler remoteDb = new RemoteDatabaseHandler("BusyFitUser");

        final List<WorkoutSchedule> workoutEntries = db.getAllWorkoutScheduleEntries();
        final ArrayList<String> theList = new ArrayList<String>();
        final ArrayList<String> descriptionList = new ArrayList<String>();

        for (int i = 0; i < workoutEntries .size(); i++) {
            theList.add(workoutEntries .get(i).getName());
            descriptionList.add(workoutEntries .get(i).getDesc());
        }

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(575f, 0));
        entries.add(new BarEntry(860f, 1));
        entries.add(new BarEntry(615f, 2));
        entries.add(new BarEntry(820f, 3));
        entries.add(new BarEntry(1100f, 4));
        entries.add(new BarEntry(910f, 5));
        entries.add(new BarEntry(750f, 6));

        BarDataSet dataSet = new BarDataSet(entries, "# of calories");
        dataSet.setColors(ColorTemplate.PASTEL_COLORS);
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Today");
        labels.add("Tue");
        labels.add("Wed");
        labels.add("Thur");
        labels.add("Fri");
        labels.add("Sat");
        labels.add("Sun");

        BarData barData = new BarData(labels, dataSet);
        BarChart barChart = (BarChart)findViewById(R.id.chart);
        barChart.animateX(2000);
        barChart.animateY(2000);
        barChart.animateXY(2000, 2000);
        barChart.setDescription("");
        barChart.setData(barData);

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theList);

        final ListView theListView = (ListView) findViewById(R.id.workout_list);

        theListView.setAdapter(theAdapter);
        theListView.isClickable();

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> theAdapter, View v,
                                    int index, long id) {
                Toast.makeText(getApplicationContext(), descriptionList.get(index), Toast.LENGTH_LONG).show();
            }
        });

        theListView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getBaseContext(), "Long Clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

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

