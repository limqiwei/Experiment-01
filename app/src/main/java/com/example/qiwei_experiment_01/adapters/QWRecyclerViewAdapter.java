package com.example.qiwei_experiment_01.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qiwei_experiment_01.R;
import com.example.qiwei_experiment_01.enums.QWRecyclerViewMode;
import com.example.qiwei_experiment_01.enums.QWRecyclerViewOrientation;
import com.example.qiwei_experiment_01.models.QWCountry;
import com.example.qiwei_experiment_01.view_holders.QWRecyclerItemViewHolder;

import java.util.List;

public class QWRecyclerViewAdapter extends RecyclerView.Adapter<QWRecyclerItemViewHolder> {

    List<QWCountry> countries;
    Context context;

    QWRecyclerViewMode QWRecyclerViewMode;
    QWRecyclerViewOrientation QWRecyclerViewOrientation;

    QWRecyclerItemViewHolder holder;

    public QWRecyclerViewAdapter(Context context, QWRecyclerViewMode QWRecyclerViewMode, QWRecyclerViewOrientation QWRecyclerViewOrientation) {
        this.context = context;
        this.QWRecyclerViewMode = QWRecyclerViewMode;
        this.QWRecyclerViewOrientation = QWRecyclerViewOrientation;
    }


    public void setCountries(List<QWCountry> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public QWRecyclerItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_layout_item, null, true);
        if (QWRecyclerViewMode == QWRecyclerViewMode.LINEAR && QWRecyclerViewOrientation == QWRecyclerViewOrientation.VERTICAL) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(layoutParams);
        }
        QWRecyclerItemViewHolder customViewHolderV1 = new QWRecyclerItemViewHolder(view);
        return customViewHolderV1;
    }

    @Override
    public void onBindViewHolder(@NonNull QWRecyclerItemViewHolder holder, int position) {
        this.holder = holder;
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
