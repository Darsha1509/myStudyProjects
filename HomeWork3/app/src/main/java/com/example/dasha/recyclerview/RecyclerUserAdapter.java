package com.example.dasha.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dasha.homework3.R;
import com.example.dasha.homework3.User;

import java.util.List;

/**
 * Created by Dasha on 24.07.2017.
 */

public class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserAdapter.ViewHolder> {

    private List<User> users;

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerUserAdapter(List<User> users) {
        this.users = users;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        // set the view's size, margins, paddings and layout parameters if necessary
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final User currentUser = users.get(position);

        holder.photo.setImageResource(currentUser.getImageId());

        holder.name.setText(currentUser.getName());

        holder.fullName.setText(currentUser.getFull_name());

        if(currentUser.isActive()){
            holder.isCheched.setVisibility(View.VISIBLE);
            holder.isCheched.setText("online");
        }else {
            holder.isCheched.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        ImageView photo;
        TextView name;
        TextView fullName;
        TextView isCheched;

        public ViewHolder(View v) {
            super(v);
            photo = (ImageView) v.findViewById(R.id.image);
            name = (TextView) v.findViewById(R.id.tv_name);
            fullName = (TextView) v.findViewById(R.id.tv_full_name);
            isCheched = (TextView) v.findViewById(R.id.tv_isChecked);
        }
    }
}
