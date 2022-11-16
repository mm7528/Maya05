package com.example.maya05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent si;
    Switch sw;
    EditText et1,et2;
    Double progressor,firstElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw = findViewById(R.id.switch1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        si=new Intent(this, MainActivity2.class);
    }

    public boolean inputOK()
    {
        String st = et1.getText().toString();
        String st2 = et2.getText().toString();
        boolean elementOk =st.matches("-?\\d+(\\.\\d+)?");
        boolean progressorOk =st2.matches("-?\\d+(\\.\\d+)?");
        if(elementOk&&progressorOk)
        {
            progressor=Double.parseDouble(st2);
            firstElement=Double.parseDouble(st);
            si.putExtra("progressor",progressor);
            si.putExtra("firstElement",firstElement);
            return true;

        }
        Toast.makeText(this, "you must enter a number!!!", Toast.LENGTH_SHORT).show();
        return false;
    }
    public void choice(View view) {
        if(sw.isChecked()) {
            sw.setText("Geometrical");
        }
        else{
            sw.setText("Mathematical");
        }
    }

    public void calculate(View view) {
        if(sw.isChecked()) {
            //1 is geometrical
            si.putExtra("type", 1);
        }
        else{
            //0 is mathematical
            si.putExtra("type", 0);
        }
        if(inputOK()) {
            startActivity(si);
        }
    }
}