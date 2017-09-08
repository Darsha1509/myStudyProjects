package com.example.dasha.homework3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.dasha.listview.UserArrayAdapter;
import com.example.dasha.recyclerview.RecyclerActivity;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    private static ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnList = (Button) findViewById(R.id.btn_list);
        Button btnRecycler = (Button) findViewById(R.id.btn_recycler);

        btnList.setOnClickListener(this);
        btnRecycler.setOnClickListener(this);

        users = new ArrayList<User>();
        users.add(new User(R.drawable.user_man, "Alex", "Alex Finder", true));
        users.add(new User(R.drawable.user_man, "Alex", "Alex Finder", true));
        users.add(new User(R.drawable.user_woman, "Vera", "Vera Finder", false));
        users.add(new User(R.drawable.user_man, "Alex", "Alex Finder", false));
        users.add(new User(R.drawable.user_woman, "Vera", "Vera Finder", false));
        users.add(new User(R.drawable.user_man, "Alex", "Alex Finder", true));
        users.add(new User(R.drawable.user_woman, "Vera", "Vera Finder", false));
        users.add(new User(R.drawable.user_man, "Alex", "Alex Finder", true));
        users.add(new User(R.drawable.user_woman, "Vera", "Vera Finder", false));
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.btn_list:
                setContentView(R.layout.activity_main);
                UserArrayAdapter userAdapter = new UserArrayAdapter(this, users);
                ListView list = (ListView) findViewById(R.id.list);
                list.setOnScrollListener(new EndlessScrollListener() {
                    @Override
                    public boolean onLoadMore(int page, int totalItemsCount) {
                        // Triggered only when new data needs to be appended to the list
                        // Add whatever code is needed to append new items to your AdapterView
                        loadNextDataFromApi(page);
                        // or loadNextDataFromApi(totalItemsCount);
                        return true; // ONLY if more data is actually being loaded; false otherwise.
                    }
                });

                list.setAdapter(userAdapter);
                break;
            case R.id.btn_recycler:
                intent = new Intent(this, RecyclerActivity.class);
                startActivity(intent);
                break;
        }


    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public void loadNextDataFromApi(int offset) {
        // Send an API request to retrieve appropriate paginated data
        //  --> Send the request including an offset value (i.e `page`) as a query parameter.
        //  --> Deserialize and construct new model objects from the API response
        //  --> Append the new data objects to the existing set of items inside the array of items
        //  --> Notify the adapter of the new items made with `notifyDataSetChanged()`
    }
}
