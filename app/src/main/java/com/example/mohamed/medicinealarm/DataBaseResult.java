package com.example.mohamed.medicinealarm;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class DataBaseResult extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Medicine>medicines=new ArrayList<Medicine>();
        DbHelper helper = new DbHelper(this);
         medicines = helper.select();
        ArrayAdapter<Medicine> adapter = new ArrayAdapter<Medicine>(
                this,android.R.layout.simple_list_item_1, medicines);
        setListAdapter(adapter);

    }
}
