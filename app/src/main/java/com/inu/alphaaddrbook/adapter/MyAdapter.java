package com.inu.alphaaddrbook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.inu.alphaaddrbook.R;

import java.util.List;

public class MyAdapter  extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Class> acts;
    private int[] mColors = {R.color.color_0,R.color.color_1,R.color.color_2,R.color.color_3,
            R.color.color_4,R.color.color_5,R.color.color_6,R.color.color_7};

    public MyAdapter(List<Class> acts) {
        this.acts = acts;
    }

    @Override
    public int getCount() {
        return acts == null ? 0:acts.size();
    }

    @Override
    public Object getItem(int position) {
        return acts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            if (inflater == null) {
                inflater = LayoutInflater.from(parent.getContext());
            }
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        convertView.setBackgroundColor(parent.getResources().getColor(mColors[position%8]));
        TextView textView = (TextView) convertView;
        textView.setText(acts.get(position).getSimpleName());
        textView.setTextColor(parent.getResources().getColor(R.color.white));
        return textView;
    }
}

