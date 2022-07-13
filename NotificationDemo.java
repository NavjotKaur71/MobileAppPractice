package com.example.firstapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotificationDemo extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);
    }

    public void go(View v)
    {
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this);

        builder.setTicker("This is Ticker Text");
        builder.setContentTitle("Hello World");
        builder.setContentText("Hello world, how are you");
        builder.setContentInfo("15");
        builder.setSmallIcon(R.drawable.yellowstar);
        builder.setOngoing(true);

        Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.drawable.android1);
        builder.setLargeIcon(bmp);

        Uri uri= Uri.parse("android.resource://"+ getPackageName()+"/"+R.raw.beep4);
        builder.setSound(uri);

        builder.setVibrate(new long[]{2000, 1000, 1000});

        Intent in=new Intent(this,CameraAndGalleryActivity.class);
        PendingIntent pin= PendingIntent.getActivity(this,0,in,0);

        builder.setContentIntent(pin);
        builder.setAutoCancel(true);

        Notification notif= builder.build();

        NotificationManager nm=(NotificationManager)(getSystemService(NOTIFICATION_SERVICE));

        nm.notify(20,notif);

    }

    public void go2(View v)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                 for(int i=0;i<=100;i=i+10)
                 {
                     NotificationCompat.Builder builder= new NotificationCompat.Builder(getApplicationContext());

                     builder.setTicker("This is Ticker Text");
                     builder.setContentTitle("Downloading..");
                     builder.setContentText(i+" % Complete");
                     builder.setContentInfo(i+"");
                     builder.setSmallIcon(R.drawable.yellowstar);

                     Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.drawable.android1);
                     builder.setLargeIcon(bmp);

                     builder.setProgress(100,i,true);


                     Notification notif= builder.build();

                     NotificationManager nm=(NotificationManager)(getSystemService(NOTIFICATION_SERVICE));

                     nm.notify(20,notif);

                     try {
                         Thread.sleep(1000);
                     }
                     catch(Exception ex)
                     {
                        ex.printStackTrace();
                     }
                 }
            }
        }).start();
    }
}



