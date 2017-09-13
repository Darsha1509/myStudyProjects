package com.example.dasha.booklistingapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 13.09.2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,
                    parent,
                    false);
        }

        Book currentBook = getItem(position);

        TextView titleTv = (TextView) listItemView.findViewById(R.id.title);
        titleTv.setText(currentBook.getTitle());

        TextView authorTv = (TextView) listItemView.findViewById(R.id.author);
        authorTv.setText(currentBook.getAuthor());

        if(currentBook.getImageResouce() !=null){
            ImageView bookImageView = (ImageView) listItemView.findViewById(R.id.imageView);
            Picasso.with(getContext())
                    .load("http://covers.openlibrary.org/b/olid/"+currentBook.getImageResouce()+"-M.jpg")
                    .into(bookImageView);
        }


        return listItemView;
    }
}
