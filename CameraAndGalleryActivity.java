package com.example.firstapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class CameraAndGalleryActivity extends AppCompatActivity
{
    ImageView imv1;
    Uri myuri;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_and_gallery);

        imv1=(ImageView)(findViewById(R.id.imv1));
    }

    public void go(View v)
    {
        Intent in=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File f=new File("/mnt/sdcard/firstpic.jpg");
        myuri= Uri.fromFile(f);
        in.putExtra(MediaStore.EXTRA_OUTPUT,myuri);

        startActivityForResult(in, 100);
    }

    public void go2(View v)
    {
        Intent galleryintent=new Intent(Intent.ACTION_PICK);
        galleryintent.setType("image/*");

        startActivityForResult(galleryintent,101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent backintent)
    {
        if(requestCode==100)  //from camera
        {
           if(resultCode==RESULT_OK)
           {
              //Method 1
              /*
              Bitmap bmp;
              bmp= (Bitmap) (backintent.getExtras().get("data"));

              if(bmp!=null)
              {
                  imv1.setImageBitmap(bmp);
              }
              */

              //Method 2
              imv1.setImageURI(myuri);
           }
        }
        else if(requestCode==101)  //from gallery
        {
            if(resultCode==RESULT_OK)
            {
               Uri uri= backintent.getData();

               Log.d("MYMESSAGE", "uri from gallery"+uri.toString()) ;
               imv1.setImageURI(uri);
            }
        }


    }

}
