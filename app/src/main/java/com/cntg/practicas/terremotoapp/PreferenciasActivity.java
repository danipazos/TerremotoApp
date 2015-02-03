package com.cntg.practicas.terremotoapp;

import android.app.Activity;
import android.content.Context;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;


public class PreferenciasActivity extends Activity {

    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Rss = "rssKey";
    public static final String Frequency = "frequencyKey";

    TextView rss;
    Spinner frequency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        rss =  (TextView) findViewById(R.id.etRss);
        frequency = (Spinner) findViewById(R.id.spFrecuencias);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Rss))
        {
            rss.setText(sharedpreferences.getString(Rss, ""));
        }

        //if (sharedpreferences.contains(Frequency))
        //{
       //     frequency.setI.setText(sharedpreferences.getString(Rss, ""));
        //}

        Button btGuardar = (Button) findViewById(R.id.btGuardar);

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePreferences(v);
            }
        });
    }

    public void savePreferences(View v){
        String rssValue  = rss.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Rss, rssValue);

        editor.commit();

    }
}
