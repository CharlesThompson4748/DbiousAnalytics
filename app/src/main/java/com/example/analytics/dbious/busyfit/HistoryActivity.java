package com.example.analytics.dbious.busyfit;

import android.content.Context;
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

/**
 * Created by charlie on 11/24/2015.
 */
public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

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




        String[] favoriteTVShows = {"South Park", "Better Off Ted",
                "Twin Peaks", "Freaks and Geeks", "Orphan Black", "Walking Dead",
                "Breaking Bad", "The 400", "Alphas", "Life on Mars"};

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, favoriteTVShows);

        ListView theListView = (ListView) findViewById(R.id.workout_list);

        theListView.setAdapter(theAdapter);
        //theListView.setOnItemClickListener(new AdapterView.OnItemClickListener());

        theListView.isClickable();
        theListView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getBaseContext(), "Long Clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}

