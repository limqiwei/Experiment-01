package com.example.qiwei_experiment_01.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qiwei_experiment_01.R;
import com.example.qiwei_experiment_01.enums.RecyclerViewMode;
import com.example.qiwei_experiment_01.enums.RecyclerViewOrientation;
import com.example.qiwei_experiment_01.models.QW_Country;
import com.example.qiwei_experiment_01.view_holders.CustomViewHolderV1;

import java.util.List;

public class CustomRecyclerAdapterV1 extends RecyclerView.Adapter<CustomViewHolderV1> {

    List<QW_Country> countries;
    Context context;

    RecyclerViewMode recyclerViewMode;
    RecyclerViewOrientation recyclerViewOrientation;

    public CustomRecyclerAdapterV1(Context context, RecyclerViewMode recyclerViewMode, RecyclerViewOrientation recyclerViewOrientation) {
        this.context = context;
        this.recyclerViewMode = recyclerViewMode;
        this.recyclerViewOrientation = recyclerViewOrientation;
    }


    public void setCountries(List<QW_Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CustomViewHolderV1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_layout_item, null, true);
        CustomViewHolderV1 customViewHolderV1 = new CustomViewHolderV1(view);
        return customViewHolderV1;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolderV1 holder, int position) {
        QW_Country country = this.countries.get(position);

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
