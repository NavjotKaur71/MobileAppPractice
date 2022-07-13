package com.example.firstapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FiveActivity extends AppCompatActivity
{
    TextView tv99;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        tv99=(TextView)(findViewById(R.id.tv99));
        pd=new ProgressDialog(this);

        pd.setTitle("Downloading...");
        pd.setMessage("From abc.com");
        pd.setIcon(R.drawable.android1);
        pd.setCancelable(false);

        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    }

    public void go(View v)
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Hello World");
        builder.setMessage("How are you");
        builder.setIcon(R.drawable.android1);
        builder.setCancelable(false);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv99.setText("Ok Clicked");
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv99.setText("cancel clicked");
            }
        });

        AlertDialog ad= builder.create();
        ad.show();

       // ad.dismiss();
    }

    public void go2(View v)
    {
       pd.show();
       //pd.setProgress(70);

       new Thread(new Runnable() {
           @Override
           public void run() {
              for(int i=1;i<=100;i++)
              {
                 pd.setProgress(i);

                  try
                  {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }

              pd.dismiss();
           }
       }).start();
    }

}
