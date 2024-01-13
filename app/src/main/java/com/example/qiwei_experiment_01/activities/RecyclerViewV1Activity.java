package com.example.qiwei_experiment_01.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qiwei_experiment_01.R;
import com.example.qiwei_experiment_01.adapters.CustomRecyclerAdapterV1;
import com.example.qiwei_experiment_01.helpers.JsonLoader;

public class RecyclerViewV1Activity extends AppCompatActivity{

    RecyclerView rvWidget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout_v1);

        rvWidget = (RecyclerView) findViewById(R.id.rvWidget);
        CustomRecyclerAdapterV1 adapter = new CustomRecyclerAdapterV1(this);
        adapter.setCountries(JsonLoader.loadCountries(this));
        rvWidget.setLayoutManager(new LinearLayoutManager(this));
        rvWidget.setAdapter(adapter);
    }



}