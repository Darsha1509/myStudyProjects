package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dasha on 25.08.2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    private int mBackgroundColor;

    public WordAdapter(Activity context, ArrayList<Word> words, int color) {

        super(context, 0, words);
        mBackgroundColor = color;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }



        Word currentWord = getItem(position);

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.background);
        RelativeLayout linearLayoutFirst = (RelativeLayout) listItemView.findViewById(R.id.first_background);
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        linearLayout.setBackgroundColor(color);
        linearLayoutFirst.setBackgroundColor(color);

        TextView miworkTextView = (TextView) listItemView.findViewById(R.id.miwork_word);
        miworkTextView.setText(currentWord.getMiworkTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_word);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.getImageResource() == 0) {
            imageView.setVisibility(View.GONE);

        } else {
            imageView.setImageResource(currentWord.getImageResource());
        }


        return listItemView;
    }
}
