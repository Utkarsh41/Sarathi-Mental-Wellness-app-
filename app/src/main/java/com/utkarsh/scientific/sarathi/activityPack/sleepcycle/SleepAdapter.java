package com.utkarsh.scientific.sarathi.activityPack.sleepcycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utkarsh.scientific.sarathi.R;

import java.util.ArrayList;


public class SleepAdapter extends RecyclerView.Adapter<SleepAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<SleepModel> courseModalArrayList;
    private Context context;

    // constructor
    public SleepAdapter(ArrayList<SleepModel> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        SleepModel modal = courseModalArrayList.get(position);
        holder.courseNameTV.setText(modal.getmDate());
        holder.courseDurationTV.setText(modal.getmTime());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView courseNameTV,  courseDurationTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);

        }
    }
}

