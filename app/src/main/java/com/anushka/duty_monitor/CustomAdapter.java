package com.anushka.duty_monitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;

    ArrayList<String> listCGPA;
    ArrayList<String> listName;
    ArrayList<String> listID;



    public CustomAdapter(Context context, ArrayList<String> listID, ArrayList<String> listName, ArrayList<String> listCGPA){
        this.context=context;
        this.listCGPA=listCGPA;
        this.listName=listName;
        this.listID=listID;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listID.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.custom_list_data, null);
        TextView tvCGPA = view.findViewById(R.id.tv_lv_cgpa);
        TextView tvName = view.findViewById(R.id.tv_lv_name);
        TextView tvID = view.findViewById(R.id.tv_lv_ID);


        tvCGPA.setText(listCGPA.get(i));
        tvName.setText(listName.get(i));
        tvID.setText(listID.get(i));


        return view;
    }
}
