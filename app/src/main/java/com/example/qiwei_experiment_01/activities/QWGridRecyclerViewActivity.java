package com.example.qiwei_experiment_01.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qiwei_experiment_01.R;
import com.example.qiwei_experiment_01.adapters.QWRecyclerViewAdapter;
import com.example.qiwei_experiment_01.enums.QWRecyclerViewMode;
import com.example.qiwei_experiment_01.enums.QWRecyclerViewOrientation;
import com.example.qiwei_experiment_01.helpers.JsonLoader;

public class QWGridRecyclerViewActivity extends AppCompatActivity{

    public static final String INTENT_PARAM_BOOLEAN_IS_VERTICAL = "isVertical";
    RecyclerView rvWidget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);

        boolean isVertical = true; // Default
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            isVertical = extras.getBoolean(QWGridRecyclerViewActivity.INTENT_PARAM_BOOLEAN_IS_VERTICAL);
        }

        rvWidget = (RecyclerView) findViewById(R.id.rvWidget);
        
        QWRecyclerViewAdapter adapter;
        if (isVertical) {
            adapter = new QWRecyclerViewAdapter(this, QWRecyclerViewMode.GRID, QWRecyclerViewOrientation.VERTICAL);
            rvWidget.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false) {
                @Override
                public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                    return true;
                }
            });
        } else {
            adapter = new QWRecyclerViewAdapter(this, QWRecyclerViewMode.GRID, QWRecyclerViewOrientation.HORIZONTAL);

            rvWidget.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.HORIZONTAL, false) {
                @Override
                public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                    lp.width = getWidth() / 2;
                    lp.height = getHeight() / 4;
                    return true;
                }
            });
        }

        adapter.setCountries(JsonLoader.loadCountries(this));
        rvWidget.setAdapter(adapter);
    }



}