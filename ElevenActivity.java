package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class ElevenActivity extends AppCompatActivity
{
    int i;
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven);

        if(savedInstanceState!=null) {
            i = savedInstanceState.getInt("x");
        }


        pbar=(ProgressBar)(findViewById(R.id.pbar1));

        new Thread(new Runnable() {
            @Override
            public void run()
            {
                while(true) {
                    i++;
                    pbar.setProgress(i);

                    if(i==100)
                        break;

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putInt("x",i);

    }
}



