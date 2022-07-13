package com.example.firstapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FragmentDemo2 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo2);
    }

    public void go(View v)
    {
        FragmentManager frm= getSupportFragmentManager();

        FragmentTransaction frt= frm.beginTransaction();

        frt.replace(R.id.ll1,new Frag1());

        frt.commit();

        Toast.makeText(this,"Frag 1 Loaded",Toast.LENGTH_LONG).show();
    }

    public void go2(View v)
    {
        FragmentManager frm= getSupportFragmentManager();

        FragmentTransaction frt= frm.beginTransaction();

        frt.replace(R.id.ll1,new Frag2());

        frt.commit();

        Toast.makeText(this,"Frag 2 Loaded",Toast.LENGTH_LONG).show();
    }



}


