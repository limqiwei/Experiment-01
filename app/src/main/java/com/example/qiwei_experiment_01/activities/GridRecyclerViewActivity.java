package com.example.qiwei_experiment_01.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qiwei_experiment_01.R;
import com.example.qiwei_experiment_01.adapters.CustomRecyclerAdapterV1;
import com.example.qiwei_experiment_01.enums.RecyclerViewMode;
import com.example.qiwei_experiment_01.enums.RecyclerViewOrientation;
import com.example.qiwei_experiment_01.helpers.JsonLoader;

public class GridRecyclerViewActivity extends AppCompatActivity{

    public static final String INTENT_PARAM_BOOLEAN_IS_VERTICAL = "isVertical";
    RecyclerView rvWidget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout_v1);

        boolean isVertical = true; // Default
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            isVertical = extras.getBoolean(GridRecyclerViewActivity.INTENT_PARAM_BOOLEAN_IS_VERTICAL);
        }

        rvWidget = (RecyclerView) findViewById(R.id.rvWidget);

        RecyclerViewOrientation rvViewOrientation;
        RecyclerView.Orientation  layoutManagerOrientation;

        CustomRecyclerAdapterV1 adapter;
        if (isVertical) {
            adapter = new CustomRecyclerAdapterV1(this, RecyclerViewMode.GRID, RecyclerViewOrientation.VERTICAL);
            rvWidget.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
        } else {
            adapter = new CustomRecyclerAdapterV1(this, RecyclerViewMode.GRID, RecyclerViewOrientation.HORIZONTAL);
            rvWidget.setLayoutManager(new GridLayoutManager(this, 7, LinearLayoutManager.HORIZONTAL, false));
        }

        adapter.setCountries(JsonLoader.loadCountries(this));
        rvWidget.setAdapter(adapter);
    }



}