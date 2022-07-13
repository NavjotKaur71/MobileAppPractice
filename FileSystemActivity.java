package com.example.firstapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileSystemActivity extends AppCompatActivity
{
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_system);

        tv1=(TextView)(findViewById(R.id.tv1));
    }

    public void go(View v)
    {
        try
        {
            //Use Environment.getExternalStorageDirectory() insted of /mnt/sdcard
            //since some phone might have different path

            File f1= Environment.getExternalStorageDirectory();
            // File f1=new File("/mnt/sdcard");

            FileWriter fw = new FileWriter(f1.getPath()+ "/one.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("hello world");
            pw.println("how are you");
            pw.println("1234567890");

            pw.flush();

            pw.close();

            Toast.makeText(this,"New File Created",Toast.LENGTH_LONG).show();
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }
    }

    public void go2(View v)
    {
       try
       {
           FileReader fr=new FileReader("/mnt/sdcard/one.txt");
           BufferedReader br=new BufferedReader(fr);

           String s;

           tv1.setText("");

           while(true)
           {
               s=br.readLine();
               if(s==null)
                   break;

               tv1.append(s+"\n");
           }
       }
       catch(Exception ex)
       {
         ex.printStackTrace();
       }
    }

    public void go3(View v)
    {
        File f=new File("/mnt/sdcard");
        String a[]= f.list();

        tv1.setText("");

        for(int i=0;i<a.length;i++)
        {
           tv1.append(a[i]+"\n");
        }
    }

    public void go4(View v)
    {
        try
        {
            FileOutputStream fos = openFileOutput("hello.txt",MODE_PRIVATE);
            PrintWriter pw=new PrintWriter(fos);

            pw.println("This is First Line");
            pw.println("This is Second Line");
            pw.println("This is Third Line");

            pw.flush();
            pw.close();

            Toast.makeText(this,"File Created in Internal Memory",Toast.LENGTH_LONG).show();
        }
        catch(Exception ex)
        {
           ex.printStackTrace();
        }
    }

    public void go5(View v)
    {
       try
       {
           FileInputStream fis = openFileInput("hello.txt");
           BufferedReader br=new BufferedReader(new InputStreamReader(fis));

           String s;

           tv1.setText("");

           while(true)
           {
              s=br.readLine();
              if(s==null)
                  break;

              tv1.append(s+"\n");
           }

       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
    }

}
