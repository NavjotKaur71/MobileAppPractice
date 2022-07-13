package com.example.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NineActivity extends AppCompatActivity
{
    TextView tv15;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);

        tv15=(TextView)(findViewById(R.id.tv15));

        Intent in= getIntent();
        String x=in.getStringExtra("a");
        int y= in.getIntExtra("b",-1);

        tv15.setText("x="+x+"\n"+"y="+y);

    }


}


