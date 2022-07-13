package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerDemoActivity extends AppCompatActivity
{
    String a[]={"abc","xyz","pqr","mno","def","hello"};
    Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);

        ArrayAdapter ad=new ArrayAdapter(this,R.layout.mysinglerow,R.id.tv111,a);
        sp1=(Spinner)(findViewById(R.id.sp1));

        sp1.setAdapter(ad);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(SpinnerDemoActivity.this,
                               a[position]+"selected",Toast.LENGTH_LONG ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
}
