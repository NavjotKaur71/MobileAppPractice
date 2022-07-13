package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridDemo extends AppCompatActivity
{
    ArrayList<Student>  al;
    GridView gv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_demo);

        al=new ArrayList<>();

        al.add(new Student(12,"abc",90,R.drawable.greenstar));
        al.add(new Student(15, "xyz", 78,R.drawable.arrow1));
        al.add(new Student(18, "pqr", 65,R.drawable.yellowstar));
        al.add(new Student(21, "mno", 92, R.drawable.arrow3));
        al.add(new Student(22, "abc", 89, R.drawable.redstar));
        al.add(new Student(23, "xyz", 72, R.drawable.arrow2));
        al.add(new Student(12,"abc",90,R.drawable.greenstar));
        al.add(new Student(15, "xyz", 78,R.drawable.arrow1));
        al.add(new Student(18, "pqr", 65,R.drawable.yellowstar));
        al.add(new Student(21,"mno",92,R.drawable.arrow3));
        al.add(new Student(22, "abc", 89, R.drawable.redstar));
        al.add(new Student(23, "xyz", 72, R.drawable.arrow2));

        gv1=(GridView)(findViewById(R.id.gv1));

        myadapter ad=new myadapter();
        gv1.setAdapter(ad);

        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridDemo.this, al.get(position).name + " selected"
                        , Toast.LENGTH_LONG).show();
            }
        });
    }

    /// Inner Class /////
    class myadapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return al.size();
        }

        @Override
        public Object getItem(int i)
        {
            return al.get(i);
        }

        @Override
        public long getItemId(int i)
        {
            return i*10;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater= LayoutInflater.from(parent.getContext());

            convertView=inflater.inflate(R.layout.studentrow,parent,false);

            Student st= al.get(i);

            TextView tv1,tv2,tv3;
            ImageView imv1;

            tv1=(TextView)(convertView.findViewById(R.id.tv1));
            tv2=(TextView)(convertView.findViewById(R.id.tv2));
            tv3=(TextView)(convertView.findViewById(R.id.tv3));
            imv1=(ImageView)(convertView.findViewById(R.id.imv1));

            tv1.setText("Rollno "+st.rollno);
            tv2.setText(st.name);
            tv3.setText("Marks "+st.marks);
            imv1.setImageResource(st.photo);

            return convertView;
        }
    }
    ////////////////////
}
