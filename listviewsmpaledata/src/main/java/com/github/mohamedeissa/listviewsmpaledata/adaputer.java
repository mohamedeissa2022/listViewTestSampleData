package com.github.mohamedeissa.listviewsmpaledata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class adaputer extends BaseAdapter {
    public Context context;
    public ArrayList<String> data;
    public int res;

    public void AddUsers(ArrayList<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    public void AddUser(String user) {
        data.add(user);
        notifyDataSetChanged();
    }
    public adaputer(Context context, int res) {
        this.res = res;
        this.context = context;
        data = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        String das = data.get(position).toLowerCase(Locale.ROOT);
        long id = Long.parseLong(das) * 2;
        return (id) + position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(res, null, false);
        }
        TextView tv = view.findViewById(R.id.tvList);
        tv.setText(data.get(position));
        notifyDataSetChanged();
        return view;
    }
}
