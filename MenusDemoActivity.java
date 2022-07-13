package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MenusDemoActivity extends AppCompatActivity
{
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_demo);

        tv1=(TextView)(findViewById(R.id.tv1));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.hello, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()== R.id.m1)
        {
            tv1.setText("Menu 1 Clicked");
        }
        else if(item.getItemId()==R.id.m2)
        {
            tv1.setText("Menu 2 Clicked");
        }

        return true;
    }
}
