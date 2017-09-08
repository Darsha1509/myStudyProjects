package com.example.dasha.listview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dasha.homework3.R;
import com.example.dasha.homework3.User;

import java.util.ArrayList;

/**
 * Created by Dasha on 19.07.2017.
 */

public class UserArrayAdapter extends ArrayAdapter<User> {

    public UserArrayAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        User currentUser = getItem(position);

        viewHolder.photo.setImageResource(currentUser.getImageId());

        viewHolder.name.setText(currentUser.getName());

        viewHolder.fullName.setText(currentUser.getFull_name());

        if(currentUser.isActive()){
            viewHolder.isCheched.setVisibility(View.VISIBLE);
            viewHolder.isCheched.setText("online");
        }else {
            viewHolder.isCheched.setVisibility(View.GONE);
        }



        return convertView;
    }

    private class ViewHolder {
        ImageView photo;
        TextView name;
        TextView fullName;
        TextView isCheched;

        public ViewHolder(View view) {
            photo = (ImageView) view.findViewById(R.id.image);
            name = (TextView) view.findViewById(R.id.tv_name);
            fullName = (TextView) view.findViewById(R.id.tv_full_name);
            isCheched = (TextView) view.findViewById(R.id.tv_isChecked);
        }
    }
}
