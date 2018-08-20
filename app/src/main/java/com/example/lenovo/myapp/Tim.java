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

public class Tim extends AppCompatActivity {

    EditText input_number;
    Spinner spinner1,spinner2;
    Button btn;
    TextView show_result;
    List<String> list2;
    List<String> list1;

    String[] units = new String[]{
            "sec","min","h","day","week","month","year"
    };
    int scale;

    double second = 1;
    double minute = 0.0166666667;
    double hour = 0.0002777778;
    double day = 0.0000115741;
    double week = 0.0000016534;
    double month = 0.0000003805;
    double year = 0.000000031709;

    double var1,var2;
    double output,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim);

        input_number = (EditText)findViewById(R.id.input);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        btn = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.show);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list1.add("second");
        list1.add("minute");
        list1.add("hour");
        list1.add("day");
        list1.add("week");
        list1.add("month");
        list1.add("year");

        list2.add("second");
        list2.add("minute");
        list2.add("hour");
        list2.add("day");
        list2.add("week");
        list2.add("month");
        list2.add("year");

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
                    var1 = second;
                }
                if (position == 1) {
                    var1 = minute;
                }
                if (position == 2) {
                    var1 = hour;
                }
                if (position == 3) {
                    var1 = day;
                }
                if (position == 4) {
                    var1 = week;
                }
                if (position == 5) {
                    var1 = month;
                }
                if (position == 6) {
                    var1 = year;
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
                    var2 = second;
                }
                if (position == 1) {
                    var2 = minute;
                }
                if (position == 2) {
                    var2 = hour;
                }
                if (position == 3) {
                    var2 = day;
                }
                if (position == 4) {
                    var2 = week;
                }
                if (position == 5) {
                    var2 = month;
                }
                if (position == 6) {
                    var2 = year;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = input_number.getText().toString();
                double no = Double.parseDouble(value);
                output = second / var1;
                output = output * var2;
                output = output * no;
                if (var2 == second) {
                    scale = 0;
                }
                if (var2 == minute) {
                    scale = 1;
                }
                if (var2 == hour) {
                    scale = 2;
                }
                if (var2 == day) {
                    scale = 3;
                }
                if (var2 == week) {
                    scale = 4;
                }
                if (var2 == month) {
                    scale = 5;
                }
                if (var2 == year) {
                    scale = 6;
                }

                show_result.setText( output+" "+units[scale]);
            }
        });




    }
}
