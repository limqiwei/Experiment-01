package com.example.qiwei_experiment_01.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qiwei_experiment_01.R;

public class QWMainActivity extends AppCompatActivity{

    Button btnTextWidgets;
    Button btnButtons;
    Button btnListView;
    Button btnRvView;
    Button btnHRvView;
    Button btnGridRvView;
    Button btnGridHRvView;

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
        btnRvView = (Button) findViewById(R.id.btnRvView);
        btnHRvView = (Button) findViewById(R.id.btnHRvView);
        btnGridRvView = (Button) findViewById(R.id.btnGridRvView);
        btnGridHRvView = (Button) findViewById(R.id.btnGridHRvView);

        this.btnButtons.setEnabled(false);
        this.btnButtons.setVisibility(View.GONE);

        btnTextWidgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QWMainActivity.this, QWTextWidgetPlaygroundActivity.class);
                startActivity(intent);
            }
        });

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QWMainActivity.this, QWListViewActivity.class);
                startActivity(intent);
            }
        });


        btnRvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QWMainActivity.this, QWLinearRecyclerViewActivity.class);
                intent.putExtra(QWLinearRecyclerViewActivity.INTENT_PARAM_BOOLEAN_IS_VERTICAL, true);
                startActivity(intent);
            }
        });

        btnHRvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QWMainActivity.this, QWLinearRecyclerViewActivity.class);
                intent.putExtra(QWLinearRecyclerViewActivity.INTENT_PARAM_BOOLEAN_IS_VERTICAL, false);
                startActivity(intent);
            }
        });

        btnGridRvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QWMainActivity.this, QWGridRecyclerViewActivity.class);
                intent.putExtra(QWGridRecyclerViewActivity.INTENT_PARAM_BOOLEAN_IS_VERTICAL, true);
                startActivity(intent);
            }
        });
        btnGridHRvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QWMainActivity.this, QWGridRecyclerViewActivity.class);
                intent.putExtra(QWGridRecyclerViewActivity.INTENT_PARAM_BOOLEAN_IS_VERTICAL, false);
                startActivity(intent);
            }
        });






    }

}