package com.example.qiwei_experiment_01.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qiwei_experiment_01.R;
import com.example.qiwei_experiment_01.adapters.QWRecyclerViewAdapter;
import com.example.qiwei_experiment_01.enums.QWRecyclerViewMode;
import com.example.qiwei_experiment_01.enums.QWRecyclerViewOrientation;
import com.example.qiwei_experiment_01.helpers.JsonLoader;

public class QWLinearRecyclerViewActivity extends AppCompatActivity{

    public static final String INTENT_PARAM_BOOLEAN_IS_VERTICAL = "isVertical";
    RecyclerView rvWidget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout_v1);

        boolean isVertical = true; // Default
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            isVertical = extras.getBoolean(QWLinearRecyclerViewActivity.INTENT_PARAM_BOOLEAN_IS_VERTICAL);
        }

        QWRecyclerViewAdapter adapter;
        if (isVertical) {
            rvWidget = (RecyclerView) findViewById(R.id.rvWidget);
            adapter = new QWRecyclerViewAdapter(this, QWRecyclerViewMode.LINEAR, QWRecyclerViewOrientation.VERTICAL);
            rvWidget.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        } else {
            rvWidget = (RecyclerView) findViewById(R.id.rvWidget);
            adapter = new QWRecyclerViewAdapter(this, QWRecyclerViewMode.LINEAR, QWRecyclerViewOrientation.HORIZONTAL);
            rvWidget.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        }

        adapter.setCountries(JsonLoader.loadCountries(this));
        rvWidget.setAdapter(adapter);
    }



}