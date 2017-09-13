package com.example.dasha.booklistingapp;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity implements android.support.v4.app.LoaderManager.LoaderCallbacks<ArrayList<Book>>{


    BookAdapter mAdapter;

    private static final String LOG_TAG = BookActivity.class.getSimpleName();

    private static final int BOOK_LOADER_ID = 1;

    ProgressBar loadingSpinner;
    EditText keyWordForSearch;
    Button searchButton;

    public static String keyWords;

    ListView bookListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookListView = (ListView) findViewById(R.id.listview);

        mAdapter = new BookAdapter(this, new ArrayList<Book>());

        bookListView.setAdapter(mAdapter);



        loadingSpinner = (ProgressBar) findViewById(R.id.loading_spinner);
        keyWordForSearch = (EditText) findViewById(R.id.edittext);
        searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyWords = keyWordForSearch.getText().toString();
                bookListView.setVisibility(View.GONE);
                loadingSpinner.setVisibility(View.VISIBLE);
                mAdapter.clear();
                getSupportLoaderManager().initLoader(BOOK_LOADER_ID, null, BookActivity.this).forceLoad();
                Log.e(LOG_TAG, "initLoader");



            }
        });
    }

    @Override
    public android.support.v4.content.Loader<ArrayList<Book>> onCreateLoader(int id, Bundle args) {
        Log.e(LOG_TAG, "onCreateLoader");

        return new BookLoader(BookActivity.this);
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<ArrayList<Book>> loader, ArrayList<Book> data) {
        mAdapter.clear();
        loadingSpinner.setVisibility(View.GONE);
        bookListView.setVisibility(View.VISIBLE);
        if(data != null && !data.isEmpty()){
            mAdapter.addAll(data);
        }
        Log.e(LOG_TAG, "onLoadFinished");
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<ArrayList<Book>> loader) {
        mAdapter.clear();
        Log.e(LOG_TAG, "onLoaderReset");
    }


    private static class BookLoader extends android.support.v4.content.AsyncTaskLoader<ArrayList<Book>> {


        public BookLoader(Context context) {
            super(context);
        }

        @Override
        protected void onStartLoading(){
            Log.e(LOG_TAG, "onStartLoading");
        }

        @Override
        public ArrayList<Book>  loadInBackground() {
            Log.e(LOG_TAG, "loadInBackground");

            return QueryUtils.getBooks();
        }
    }


}
