package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListDemo2 extends AppCompatActivity
{
    ListView lv1;
    String a[] = {"abc", "xyz", "pqr", "mno", "def", "asd", "hello"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo2);

        lv1=(ListView)(findViewById(R.id.lv1));

        ArrayAdapter ad=new ArrayAdapter(this,R.layout.mysinglerow,R.id.tv111,a);

        lv1.setAdapter(ad);
    }
}
