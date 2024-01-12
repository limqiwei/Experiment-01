package com.example.qiwei_experiment_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnOpenFragment;

    Button btnPressMe;
    Context context;

    Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        this.count = 0;
        this.init();
    }



    private void init() {
        // Bind Button
        btnOpenFragment = findViewById(R.id.btnOpenFragment);
        btnPressMe = findViewById(R.id.btnPressMe);

        setOnClickListener(btnPressMe);
        setOnClickListener(btnOpenFragment);
    }
    protected void setOnClickListener(View view) {
        if (view.getId() == R.id.btnPressMe) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                }
            });
        }

        if (view.getId() == R.id.btnOpenFragment) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentA fragmentA = FragmentA.newInstance(count);
                    fragmentA.show(getSupportFragmentManager(), FragmentA.TAG_FRAGMENT_A);
                }
            });

        }

    }


}