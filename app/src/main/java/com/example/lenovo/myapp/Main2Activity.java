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

public class Main2Activity extends AppCompatActivity {

    EditText input_number;
    Spinner spinner1,spinner2;
    Button btn;
    TextView show_result;
    List<String> list2;
    List<String> list1;

    int scale;

    Double atm = 1.0;
    Double bar = 1.01325;
    Double pascal = 101325.0;
    Double pound_force = 14.6959;
    Double torr = 760.0;

    Double var1,var2,output,no;

    String[] units = new String[] {"Atm","Bar","Pascal","p-force","torr"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        input_number = (EditText)findViewById(R.id.input);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        btn = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.show);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list1.add("Atmosphere");
        list1.add("Bar");
        list1.add("Pascal");
        list1.add("Pound-force");
        list1.add("Torr");

        list2.add("Atmosphere");
        list2.add("Bar");
        list2.add("Pascal");
        list2.add("Pound-force");
        list2.add("Torr");

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
                    var1 = atm;
                }
                if (position == 1) {
                    var1 = bar;
                }
                if (position == 2) {
                    var1 = pascal;
                }
                if (position == 3) {
                    var1 = pound_force;
                }
                if (position == 4) {
                    var1 = torr;
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
                    var2 = atm;
                }
                if (position == 1) {
                    var2 = bar;
                }
                if (position == 2) {
                    var2 = pascal;
                }
                if (position == 3) {
                    var2 = pound_force;
                }
                if (position == 4) {
                    var2 = torr;
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
                output = atm/ var1;
                output = output * var2;
                output = output * no;
                if (var2 == atm) {
                    scale = 0;
                }
                if (var2 == bar) {
                    scale = 1;
                }
                if (var2 == pascal) {
                    scale = 2;
                }
                if (var2 == pound_force) {
                    scale = 3;
                }
                if (var2 == torr) {
                    scale = 4;
                }


                show_result.setText( output+" "+units[scale]);
            }
        });



    }
}
