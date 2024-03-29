package com.example.qiwei_experiment_01.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qiwei_experiment_01.R;
import com.example.qiwei_experiment_01.models.QWCountry;

import java.util.ArrayList;

public class QWListAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<QWCountry> countries;

    public QWListAdapter(Context context, ArrayList<QWCountry> countries) {
        this.countries = countries;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.countries.size();
    }

    @Override
    public Object getItem(int position) {
        return this.countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.countries.get(position).getCode().hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        QWCountry currentCountry = (QWCountry) this.getItem(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_layout_item, null, true);
        }
        TextView tvCountryName = (TextView) convertView.findViewById(R.id.tvCountryName);
        TextView tvCountryCode = (TextView) convertView.findViewById(R.id.tvCountryCode);
        tvCountryName.setText(currentCountry.getName());
        tvCountryCode.setText(currentCountry.getCode());
        return convertView;
    }
}
