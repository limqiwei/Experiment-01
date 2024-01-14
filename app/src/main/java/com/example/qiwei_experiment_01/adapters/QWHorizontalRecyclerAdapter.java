package com.example.qiwei_experiment_01.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qiwei_experiment_01.R;
import com.example.qiwei_experiment_01.models.QWCountry;
import com.example.qiwei_experiment_01.view_holders.QWRecyclerItemViewHolder;

import java.util.List;

public class QWHorizontalRecyclerAdapter extends RecyclerView.Adapter<QWRecyclerItemViewHolder> {

    List<QWCountry> countries;
    Context context;

    public QWHorizontalRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setCountries(List<QWCountry> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public QWRecyclerItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_layout_item, null, true);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        QWRecyclerItemViewHolder customViewHolderV1 = new QWRecyclerItemViewHolder(view);
        return customViewHolderV1;
    }

    @Override
    public void onBindViewHolder(@NonNull QWRecyclerItemViewHolder holder, int position) {
        QWCountry country = this.countries.get(position);

        holder.tvCountryName.setText(country.getName());
        holder.tvCountryCode.setText(country.getCode());
        holder.viewSelected = false;

        holder.mcvCountryItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.llCountryItem.setBackgroundResource((holder.viewSelected == false) ? R.drawable.light_green_gradient : R.color.white);
                holder.viewSelected = !holder.viewSelected;
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.countries.size();
    }
}
