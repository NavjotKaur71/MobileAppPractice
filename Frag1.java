package com.example.firstapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Frag1 extends Fragment
{
    TextView tv999;
    Button bt99;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                                          Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
               
        tv999=(TextView)(getActivity().findViewById(R.id.tv999));
        bt99=(Button)(getActivity().findViewById(R.id.bt99));

        bt99.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tv999.setText(Math.random()+"");
            }
        });
    }

}





