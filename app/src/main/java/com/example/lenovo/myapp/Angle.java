package com.example.lenovo.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

public class Angle extends AppCompatActivity {

    EditText input_number;
    Spinner spinner1,spinner2;
    Button btn;
    TextView show_result;
    List<String> list2;
    List<String> list1;

    int scale;

    Double var1,var2,output,no;

    String[] units = new String[] {"deg","rad","min","sec","sign","quad","rev"};

    Double degree = 1.0;
    Double radian = 0.017453292519943;
    Double minute = 60.0;
    Double second = 3600.0;
    Double sign = 0.033333333333333;
    Double quadrant = 0.011111111111111;
    Double revolution = 0.0027777777777778;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle);


        input_number = (EditText)findViewById(R.id.input);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        btn = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.show);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list1.add("Degree");
        list1.add("Radian");
        list1.add("Minute");
        list1.add("Second");
        list1.add("Sign");
        list1.add("Quadrant");
        list1.add("Revolution");

        list2.add("Degree");
        list2.add("Radian");
        list2.add("Minute");
        list2.add("Second");
        list2.add("Sign");
        list2.add("Quadrant");
        list2.add("Revolution");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list2);

        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner1.setSelection(position);
                if (position == 0) {
                    var1 = degree;
                }
                if (position == 1) {
                    var1 = radian;
                }
                if (position == 2) {
                    var1 = minute;
                }
                if (position == 3) {
                    var1 = second;
                }
                if (position == 4) {
                    var1 = sign;
                }
                if (position == 5) {
                    var1 = quadrant;
                }
                if (position == 6) {
                    var1 = revolution;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner2.setSelection(position);
                if (position == 0) {
                    var2 = degree;
                }
                if (position == 1) {
                    var2 = radian;
                }
                if (position == 2) {
                    var2 = minute;
                }
                if (position == 3) {
                    var2 = second;
                }
                if (position == 4) {
                    var2 = sign;
                }
                if (position == 5) {
                    var2 = quadrant;
                }
                if (position == 6) {
                    var2 = revolution;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no = Double.parseDouble(input_number.getText().toString());
                output = degree / var1;
                output = output * var2;
                output = output * no;
                if (var2 == degree) {
                    scale = 0;
                }
                if (var2 == radian) {
                    scale = 1;
                }
                if (var2 == minute) {
                    scale = 2;
                }
                if (var2 == second) {
                    scale = 3;
                }
                if (var2 == sign) {
                    scale = 4;
                }
                if (var2 == quadrant) {
                    scale = 5;
                }
                if (var2 == revolution) {
                    scale = 6;
                }

                show_result.setText( output+" "+units[scale]);
            }
        });



    }
}
