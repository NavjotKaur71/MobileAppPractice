package com.example.firstapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SixActivity extends AppCompatActivity
{
    ProgressBar pbar;
    TextView tv22;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        pbar=(ProgressBar)(findViewById(R.id.progressBar4));
        tv22=(TextView)(findViewById(R.id.tv22));

    }

    public void go(View v)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {

              for(int i=1;i<=100;i++)
              {
                  final int x=i;
                  pbar.setProgress(x);

                  //Cannot update GUI Directly
                  //tv22.setText(i+" %");

                  runOnUiThread(new Runnable()
                  {
                      @Override
                      public void run() {
                          tv22.setText(x+"%");
                      }
                  });

                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }

            }
        }).start();
    }
}
