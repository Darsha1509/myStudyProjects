package com.example.dasha.recyclerview;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.dasha.homework3.R;
import com.example.dasha.homework3.StartActivity;

import static android.widget.GridLayout.VERTICAL;

public class RecyclerActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Button btnHorizontal = (Button) findViewById(R.id.btn_horizontal);
        Button btnVertical = (Button) findViewById(R.id.btn_vertical);
        Button btnGrid = (Button) findViewById(R.id.btn_grid);

        btnHorizontal.setOnClickListener(this);
        btnVertical.setOnClickListener(this);
        btnGrid.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_horizontal:
                setContentView(R.layout.activity_recyclerview);
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
                mRecyclerView.setHasFixedSize(true);
                // use a linear layout manager
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                // specify an adapter (see also next example)
                mAdapter = new RecyclerUserAdapter(StartActivity.getUsers());
                mRecyclerView.setAdapter(mAdapter);
                break;
            case R.id.btn_vertical:
                setContentView(R.layout.activity_recyclerview);
                mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                mAdapter = new RecyclerUserAdapter(StartActivity.getUsers());
                mRecyclerView.setAdapter(mAdapter);
                break;
            case R.id.btn_grid:
                setContentView(R.layout.activity_recyclerview);
                mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false));
                mAdapter = new RecyclerUserAdapter(StartActivity.getUsers());
                mRecyclerView.setAdapter(mAdapter);
                break;
            default:
                break;
        }

    }
}

