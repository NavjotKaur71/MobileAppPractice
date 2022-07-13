package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteDemo extends AppCompatActivity
{
    String a[]={"abc","xyz","mno","def","hello","world","amrinder","shalinder","vmm","rahul","varun","aman","amandeep","raman","jasmeet","navneet","manik","shubh","manpreet","ashu"};
    AutoCompleteTextView atv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_demo);

        atv1=(AutoCompleteTextView)(findViewById(R.id.atv1));

        ArrayAdapter ad=new ArrayAdapter(this,R.layout.mysinglerow,R.id.tv111,a);

        atv1.setAdapter(ad);
    }
}




