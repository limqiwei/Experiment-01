package com.example.qiwei_experiment_01.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qiwei_experiment_01.R;

public class MainActivity extends AppCompatActivity{

    Button btnTextWidgets;
    Button btnButtons;
    Button btnListView;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }



    private void init() {
        // Bind Button
        btnTextWidgets = (Button) findViewById(R.id.btnTextWidgets);
        btnButtons = (Button) findViewById(R.id.btnButtons);
        btnListView = (Button) findViewById(R.id.btnListView);

        this.btnButtons.setEnabled(false);

        btnTextWidgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextWidgetActivity.class);
                startActivity(intent);
            }
        });

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });



    }

}