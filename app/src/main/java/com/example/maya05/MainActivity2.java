package com.example.maya05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView tv1,tv2,tv3,tv4;
    ListView lv;
    int type =0;
    double firstElement, progressor, sum;
    String[] arr= new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv= findViewById(R.id.lv);
        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        Intent gi= getIntent();
        type=gi.getIntExtra("type", -1);
        progressor=gi.getDoubleExtra("progressor", 0);
        firstElement=gi.getDoubleExtra("firstElement", -1);
        arr[0] = firstElement + "";
        tv1.setText(firstElement+" ");
        tv2.setText(progressor+" ");

        if(type==0) {
            for (int i = 1; i < arr.length; i++)
                arr[i] = (firstElement + progressor * (i)) + "";
        }
        else{
            for (int i = 1; i < arr.length; i++)
                arr[i] = String.format("%s", (firstElement * Math.pow(progressor,i)));
        }
        ArrayAdapter<String> adp= new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        lv.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        tv3.setText(i + 1+ " ");
        if (type==0){
            sum = ((2*firstElement +i*progressor)*(i+1))/2;
        }
        else{
            sum= firstElement* (((Math.pow(progressor,i+1))-1)/(progressor-1));
        }
        tv4.setText(String.format("%s", sum));
    }
}