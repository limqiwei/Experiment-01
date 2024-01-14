package com.example.qiwei_experiment_01.helpers;

import android.content.Context;

import com.example.qiwei_experiment_01.models.QWCountry;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonLoader {

    public static ArrayList<QWCountry> loadCountries(Context context){

        ArrayList<QWCountry> countries = new ArrayList<>();

        String jsonString;

        InputStream is = null;
        try {
            is = context.getAssets().open("countries.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            jsonString = "";
            e.printStackTrace();
        }

        Type listCountryType = new TypeToken<List<QWCountry>>() { }.getType();

        Gson gson = new Gson();
        countries = gson.fromJson(jsonString,listCountryType);

        return countries;
    }
}
