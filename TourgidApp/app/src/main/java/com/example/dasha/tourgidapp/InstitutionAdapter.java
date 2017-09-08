package com.example.dasha.tourgidapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dasha on 04.09.2017.
 */

public class InstitutionAdapter extends ArrayAdapter<Institution> {
    int mDrawableResourceId;

    public InstitutionAdapter(Context context, ArrayList<Institution> institutions, int drawableResourceId) {
        super(context, 0, institutions);
        mDrawableResourceId = drawableResourceId;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        Institution currentInstitution = getItem(position);

        TextView address = (TextView) listItemView.findViewById(R.id.address);
        address.setText(currentInstitution.getAddress());

        TextView hours = (TextView) listItemView.findViewById(R.id.hours);
        hours.setText(currentInstitution.getBusinessHours());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(mDrawableResourceId);

        return listItemView;
    }
}
