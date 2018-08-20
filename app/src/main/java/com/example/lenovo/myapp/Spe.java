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

public class Spe extends AppCompatActivity {

    EditText input_number;
    Spinner spinner1,spinner2;
    Button btn;
    TextView show_result;
    List<String> list2;
    List<String> list1;

    String[] units = new String[]{
            "m/s","km/h","miles/h","foot/s","knot"
    };
    int scale;

    double meterpersecond = 1;
    double kilometerperhour = 3.6;
    double milesperhour = 2.23694;
    double footpersecond = 3.2808;
    double knot = 1.9438;

    double var1,var2;
    double output,no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spe);

        input_number = (EditText)findViewById(R.id.input);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        btn = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.show);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list1.add("meter/sec");
        list1.add("kilometer/sec");
        list1.add("miles/hour");
        list1.add("foot/sec");
        list1.add("knot");

        list2.add("meter/sec");
        list2.add("kilometer/sec");
        list2.add("miles/hour");
        list2.add("foot/sec");
        list2.add("knot");

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
                    var1 = meterpersecond;
                }
                if (position == 1) {
                    var1 = kilometerperhour;
                }
                if (position == 2) {
                    var1 = milesperhour;
                }
                if (position == 3) {
                    var1 = footpersecond;
                }
                if (position == 4) {
                    var1 = knot;
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
                    var2 = meterpersecond;
                }
                if (position == 1) {
                    var2 = kilometerperhour;
                }
                if (position == 2) {
                    var2 = milesperhour;
                }
                if (position == 3) {
                    var2 = footpersecond;
                }
                if (position == 4) {
                    var2 = knot;
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
                output = meterpersecond / var1;
                output = output * var2;
                output = output * no;
                if (var2 == meterpersecond) {
                    scale = 0;
                }
                if (var2 == kilometerperhour) {
                    scale = 1;
                }
                if (var2 == milesperhour) {
                    scale = 2;
                }
                if (var2 == footpersecond) {
                    scale = 3;
                }
                if (var2 == knot) {
                    scale = 4;
                }


                show_result.setText( output+" "+units[scale]);
            }
        });


    }
}
