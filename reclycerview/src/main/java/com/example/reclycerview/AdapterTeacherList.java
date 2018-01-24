package com.example.reclycerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ashish on 15/1/18.
 */

public class AdapterTeacherList extends RecyclerView.Adapter<AdapterTeacherList.ViewHolder> {

    public static final String TAG = AdapterTeacherList.class.getCanonicalName();
    private List<String> listTeachers;
    private Context context;

    public AdapterTeacherList(List<String> listTeachers, Context context) {
        this.listTeachers = listTeachers;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder:");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_cardlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterTeacherList.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder:");
        holder.teacherName.setText(listTeachers.get(position));
    }

    @Override
    public int getItemCount() {
        return listTeachers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView teacherName;

        public ViewHolder(View itemView) {
            super(itemView);
            teacherName = itemView.findViewById(R.id.txtTeacherName);
        }
    }
}