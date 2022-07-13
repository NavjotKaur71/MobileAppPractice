package com.example.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    TextView tv;
    Button bt2,bt3;
    EditText et10;

    TextView tv55;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv=(TextView)(findViewById(R.id.tv1));

        bt2=(Button)(findViewById(R.id.bt2));
        bt3=(Button)(findViewById(R.id.bt3));
        et10=(EditText)(findViewById(R.id.et10));

        tv55=(TextView)(findViewById(R.id.tv55));

        bt2.setOnClickListener(this);

        bt3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               Toast.makeText(MainActivity.this,"how are you",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //This called onclick of bt1
    public void go(View v)
    {
       tv.setText(Math.random() + "");
    }


    public void onClick(View v)
    {
        Toast.makeText(this,"Hello World",Toast.LENGTH_SHORT).show();
    }

    public void go2(View v)
    {
        //Launch TwoActivity
        Intent in=new Intent(this,TwoActivity.class);
        startActivity(in);
    }

    public void go5(View v)
    {
        Intent in=new Intent(this,ThreeActivity.class);
        startActivity(in);
    }

    public void go6(View v)
    {
        Intent in=new Intent(this,FourActivity.class);
        startActivity(in);
    }

    public void go7(View v)
    {
        Intent in=new Intent(this, FiveActivity.class);
        startActivity(in);
    }

    public void go8(View v)
    {
       Intent in=new Intent(this,SixActivity.class);
       startActivity(in);
    }

    public void go9(View v)
    {
       Intent in=new Intent(this,SevenActivity.class);
       startActivity(in);
    }

    public void go10(View v)
    {
        Intent in=new Intent(this,ChatActivity.class);
        startActivity(in);
    }

    public void go11(View v)
    {
        Intent in=new Intent(this, LifeCycleDemo.class);
        startActivity(in);
    }

    public void go12(View v)
    {
       Intent in=new Intent(this,NineActivity.class);

       String p= et10.getText().toString();
       in.putExtra("a",p);
       in.putExtra("b",123);

       startActivity(in);
    }

    public void go13(View v)
    {
        Intent intent=new Intent(this,TenActivity.class);
        startActivityForResult(intent, 80);
    }

    public void go14(View v)
    {
        Intent intent=new Intent(this,ElevenActivity.class);
        startActivity(intent);
    }

    public void go15(View v)
    {
        Intent intent=new Intent("com.anything");
        startActivity(intent);
    }

    public void go16(View v)
    {
        Intent intent=new Intent(this,CommonIntentsActivity.class);
        startActivity(intent);
    }

    public void go17(View v)
    {
        Intent intent=new Intent(this, CameraAndGalleryActivity.class);
        startActivity(intent);
    }

    public void go18(View v)
    {
        Intent intent=new Intent(this, FileSystemActivity.class);
        startActivity(intent);
    }

    public void go19(View v)
    {
        Intent intent=new Intent(this, ListDemo1.class);
        startActivity(intent);
    }

    public void go20(View v)
    {
        Intent intent=new Intent(this, ListDemo2.class);
        startActivity(intent);
    }

    public void go21(View v)
    {
        Intent intent=new Intent(this, ListDemo3.class);
        startActivity(intent);
    }

    public void go22(View v)
    {
        Intent intent=new Intent(this, GridDemo.class);
        startActivity(intent);
    }

    public void go23(View v)
    {
        Intent intent=new Intent(this, SpinnerDemoActivity.class);
        startActivity(intent);
    }

    public void go24(View v)
    {
        Intent intent=new Intent(this, AutoCompleteDemo.class);
        startActivity(intent);
    }

    public void go25(View v)
    {
        Intent intent=new Intent(this, FragmentDemoActivity1.class);
        startActivity(intent);
    }

    public void go26(View v)
    {
        Intent intent=new Intent(this, FragmentDemo2.class);
        startActivity(intent);
    }

    public void go27(View v)
    {
        Intent intent=new Intent(this, NotificationDemo.class);
        startActivity(intent);
    }

    public void go28(View v)
    {
        Intent intent=new Intent(this, MenusDemoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
           if(requestCode==80)
           {
               if(resultCode==RESULT_OK)
               {
                   String a= data.getStringExtra("p");
                   tv55.setText("Value from TenActivity\n"+a);
               }
           }
           else if(requestCode==90)
           {

           }
    }
}
