package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDemo1 extends AppCompatActivity
{
    ListView lv1;
    String a[] = {"abc", "xyz", "pqr", "mno", "def", "asd", "hello"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo1);

        lv1 = (ListView) (findViewById(R.id.lv1));

        ArrayAdapter ad =
                new ArrayAdapter(this, android.R.layout.simple_list_item_1, a);

        lv1.setAdapter(ad);
    }
}
