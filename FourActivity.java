package com.example.firstapplication;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class FourActivity extends AppCompatActivity
{
    int a[]={R.drawable.android1,R.drawable.android2,R.drawable.android3,R.drawable.android4};
    ImageView imv;
    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        imv=(ImageView)(findViewById(R.id.imv1));
    }

    public void next(View v)
    {
       if(pos==3)
       {
           Toast.makeText(this,"Already at Last Image",Toast.LENGTH_LONG).show();
       }
       else
       {
           pos++;
           Bitmap bmp = BitmapFactory.decodeResource(getResources(), a[pos]);
           imv.setImageBitmap(bmp);
       }
    }

    public void prev(View v)
    {
        if(pos==0)
        {
            Toast.makeText(this,"Already at First Image",Toast.LENGTH_LONG).show();
        }
        else
        {
            pos--;
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), a[pos]);
            imv.setImageBitmap(bmp);
        }
    }

    public void setwall(View v)
    {
        try
        {
            WallpaperManager wm = WallpaperManager.getInstance(this);
            wm.setResource(a[pos]);

            Toast.makeText(this,"Wallpaper Changed",Toast.LENGTH_LONG).show();
        }
        catch(Exception ex)
        {
           ex.printStackTrace();
        }
    }

}


