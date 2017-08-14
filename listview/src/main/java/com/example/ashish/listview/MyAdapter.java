package com.example.ashish.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ashish on 8/1/2017.
 */

public class MyAdapter extends BaseAdapter {


    private final Context context;
    private final List<MyItem> items;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<MyItem> items) {
        this.context = context;
        this.items = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int pos) {
        return items.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos * 2;
    }
    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        View viewInflated = inflater.inflate(R.layout.list_item, null, false);
        TextView txv = viewInflated.findViewById(R.id.txt);
        txv.setText(items.get(pos).getName());
        ImageView imageView = viewInflated.findViewById(R.id.img);
        imageView.setImageResource(items.get(pos).getImage());
        return viewInflated;

    }
}