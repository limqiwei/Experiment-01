package com.example.qiwei_experiment_01.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qiwei_experiment_01.helpers.JsonLoader;
import com.example.qiwei_experiment_01.R;
import com.example.qiwei_experiment_01.adapters.ListAdapterExample;

public class ListViewActivity extends AppCompatActivity{

    ListView lvListExample;

    String[] countries={"India","Australia","West indies","indonesia","Indiana",
            "South Africa","England","Bangladesh","Srilanka","singapore"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        lvListExample = (ListView)findViewById(R.id.lvListExample);
        lvListExample.setDivider(null);
        lvListExample.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                view.setBackground(lvListExample.getBackground());
            }
        });
        lvListExample.setAdapter(new ListAdapterExample(this, JsonLoader.loadCountries(this)));
    }



}