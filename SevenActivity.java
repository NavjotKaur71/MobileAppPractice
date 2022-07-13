package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class SevenActivity extends AppCompatActivity
{
    CheckBox c1;
    TextView tv1;
    Switch s1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        c1=(CheckBox)(findViewById(R.id.c1));
        tv1=(TextView)(findViewById(R.id.tv1));
        s1=(Switch)(findViewById(R.id.switch1));

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    tv1.setText("WI-FI ON");
                }
                else
                {
                    tv1.setText("WI-FI OFF");
                }
            }
        });


        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                   tv1.setVisibility(View.VISIBLE);
                }
                else
                {
                  tv1.setVisibility(View.GONE);
                }
            }
        });




    }

}
