package com.example.mohamed.medicinealarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Repeating_activity extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repeating_activity);
        t=(TextView)findViewById(R.id.med);
        Intent i=getIntent();
        t.setText(i.getStringExtra("med_namei"));


    }
}
