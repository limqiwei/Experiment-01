package com.example.qiwei_experiment_01;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class FragmentA extends DialogFragment {



    View layout;

    TextView tvNumberOfTimesPressed;

    Integer numberOfTimesPressed;

    public static final String TAG_FRAGMENT_A = "FragmentA";
    public static final String PARAM_TIMES_PRESSED = "timesPressed";

    public static FragmentA newInstance(Integer timesPressed) {

        Bundle args = new Bundle();
        FragmentA fragment = new FragmentA();
        args.putInt(PARAM_TIMES_PRESSED, timesPressed);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.numberOfTimesPressed = getArguments().getInt(PARAM_TIMES_PRESSED);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         layout = inflater.inflate(R.layout.test_fragment, container, false);
         this.tvNumberOfTimesPressed = layout.findViewById(R.id.tvNumberOfTimesPressed);

         this.tvNumberOfTimesPressed.setText(this.numberOfTimesPressed.toString());
         return layout;
    }
}
