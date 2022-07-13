package com.example.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TenActivity extends AppCompatActivity
{
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten);

        et1=(EditText)(findViewById(R.id.et1));
    }

    public void go(View v)
    {
        Intent backintent=new Intent();

        String s= et1.getText().toString();
        backintent.putExtra("p",s);

        setResult(RESULT_OK,backintent);

        finish();
    }
}
