package com.example.mohamed.medicinealarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;



public class DbHelper extends SQLiteOpenHelper {

    public static final String TABLE_Medicine = "medicine";

    public DbHelper(Context c) {
        super(c, "medicine", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE Table " +TABLE_Medicine + "(" +
                "id integer primary key autoincrement" +
                ",med_name varchar(50) not null, hour integer(50),min integer(50))";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP Table " + TABLE_Medicine;
        db.execSQL(query);
        onCreate(db);
    }

    public void insert(Medicine s) {
        ContentValues cv = new ContentValues();
        cv.put("med_name", s.getMed_name());
        cv.put("hour", s.getHour());
        cv.put("min", s.getMinute());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_Medicine, "", cv);
    }





    String[] cols = {"med_name", "hour","min"};



    public ArrayList<Medicine> select() {
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Cursor c = db.query(TABLE_Medicine, cols, null, null, null, null, null);

        int med_nameIdx = c.getColumnIndex("med_name");
        int hourIdx = c.getColumnIndex("hour");
        int minIdx = c.getColumnIndex("min");


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

            String med_name = c.getString(med_nameIdx);
            int hour = c.getInt(hourIdx);
            int min = c.getInt(minIdx);



            Medicine s = new Medicine();
            s.setMed_name(med_name);
            s.setHour(hour);
            s.setMinute(min);

            medicines.add(s);
        }
        return medicines;
    }

}
