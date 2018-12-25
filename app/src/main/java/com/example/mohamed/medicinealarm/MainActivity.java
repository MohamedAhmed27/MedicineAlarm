package com.example.mohamed.medicinealarm;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText t1;
    TimePicker p1;
    Button b, b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button);
        p1 = (TimePicker) findViewById(R.id.time);
        t1 = (EditText) findViewById(R.id.med_name);
        b1 = (Button) findViewById(R.id.database_tv);
        b.setOnClickListener(this);
        b1.setOnClickListener(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button:
                Calendar calendar = Calendar.getInstance();
                DbHelper helper = new DbHelper(this);
                Medicine s = new Medicine();
                s.setMed_name(t1.getText().toString());
                s.setHour(p1.getHour());
                s.setMinute(p1.getMinute());
                helper.insert(s);


                calendar.set(Calendar.HOUR_OF_DAY, p1.getHour());
                calendar.set(Calendar.MINUTE, p1.getMinute());
                calendar.set(Calendar.SECOND, 20);
                Toast.makeText(this, "Alarm has been set", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, Notification_Reciver.class);
                i.putExtra("med_name", t1.getText().toString());

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, i, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                break;
            case R.id.database_tv:
                Intent intent = new Intent(this, DataBaseResult.class);
                startActivity(intent);

        }


    }

}
