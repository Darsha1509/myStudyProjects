package com.example.dasha.recyclerviewoptionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<RecycleItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        //Generate sample data

        for(int i =0; i<10;i++){
            RecycleItem item = new RecycleItem("Item " + (i+1),
                    "Welcom to Torisan chanel, this is description of item " +(i+1));
            listItems.add(item);
        }

        //Set adapter

        myAdapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(myAdapter);

    }
}
