package com.example.qiwei_experiment_01.view_holders;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qiwei_experiment_01.R;
import com.google.android.material.card.MaterialCardView;

public class CustomViewHolderV1 extends RecyclerView.ViewHolder {

    public TextView tvCountryName;
    public TextView tvCountryCode;
    public MaterialCardView mcvCountryItem;
    public LinearLayout llCountryItem;
    public View view;

    public boolean viewSelected;

    public CustomViewHolderV1(@NonNull View itemView) {
        super(itemView);
        tvCountryName = (TextView) itemView.findViewById(R.id.tvCountryName);
        tvCountryCode = (TextView) itemView.findViewById(R.id.tvCountryCode);
        mcvCountryItem = (MaterialCardView) itemView.findViewById(R.id.mcvCountryItem);
        llCountryItem = (LinearLayout) itemView.findViewById(R.id.llCountryItem);

        view = itemView;
    }


}
