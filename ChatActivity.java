package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatActivity extends AppCompatActivity
{
    EditText et1,et2;
    Button bt1,bt2;
    TextView tv100;

    ChatClient chatClient;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        et1=(EditText)(findViewById(R.id.et1));
        bt1=(Button)(findViewById(R.id.bt1));
        et2=(EditText)(findViewById(R.id.et2));
        tv100=(TextView)(findViewById(R.id.tv100));
        bt2=(Button)(findViewById(R.id.bt2));
    }

    ///  Inner Class  ////
     class ChatClient implements Runnable
    {
        Socket sock;
        PrintWriter pw;
        BufferedReader brn;
        String ip;

        ChatClient(String ip)
        {
            this.ip = ip;
        }

        public void run()
        {
            try
            {
                sock = new Socket(ip, 9000);
                pw = new PrintWriter(sock.getOutputStream());
                brn = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ChatActivity.this, "Connected to Server", Toast.LENGTH_LONG).show();

                        et1.setVisibility(View.GONE);
                        bt1.setVisibility(View.GONE);

                        tv100.setVisibility(View.VISIBLE);
                        et2.setVisibility(View.VISIBLE);
                        bt2.setVisibility(View.VISIBLE);
                    }
                });

                //receive messages from Server
                while(true)
                {
                   try
                   {
                       final String p = brn.readLine();

                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               tv100.append(p + "\n");
                           }
                       });
                   }
                   catch(Exception ex)
                   {
                     ex.printStackTrace();
                   }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
    /////////////////////

    public void connect(View v)
    {
        try
        {
           String s=  et1.getText().toString();
           chatClient=new ChatClient(s);
           Thread t=new Thread(chatClient);
           t.start();
        }
        catch(Exception ex)
        {
           ex.printStackTrace();
        }
    }

    public void sendmessage(View v)
    {
        String s=et2.getText().toString();
        chatClient.pw.println(s);
        chatClient.pw.flush();
        tv100.append(s+"\n");
        et2.setText("");

    }
}
