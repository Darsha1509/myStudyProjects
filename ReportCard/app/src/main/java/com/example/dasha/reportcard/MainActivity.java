package com.example.dasha.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<ReportCard> result = new ArrayList<ReportCard>();
        result.add(new ReportCard("Name: ", "Darya Kokorina"));
        result.add(new ReportCard("English grade: ", "B+"));
        result.add(new ReportCard("English grade: ", "B+"));
        result.add(new ReportCard("ComputerSience grade: ", "C+"));
        result.add(new ReportCard("Android grade: ", "A-"));
        result.add(new ReportCard("JavaSE grade: ", "C+"));
        result.add(new ReportCard("BusinessAnalyst grade: ", "A+"));
        result.add(new ReportCard("AppArchitect grade: ", "A-"));
        result.add(new ReportCard("Managenet grade: ", "B+"));
        result.add(new ReportCard("Finance grade: ", "A-"));
        result.add(new ReportCard("French grade: ", "B+"));



        ArrayAdapter<ReportCard> mAdapter = new ArrayAdapter<ReportCard>(
                this,
                android.R.layout.simple_list_item_1,
                result);

        listView.setAdapter(mAdapter);
    }
}
