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

public class Force extends AppCompatActivity {

    EditText input_number;
    Spinner spinner1,spinner2;
    Button btn;
    TextView show_result;
    List<String> list2;
    List<String> list1;

    int scale;

    Double var1,var2,output,no;

    String[] units = new String[] {"bits","bytes","Kb","Mb","Gb","Tb","Pb"};

    Double bit = 1.0;
    Double bytes = 0.125;
    Double kilobytes = 0.000125;
    Double megabytes = 0.000000125;
    Double gigabytes = 0.000000000125;
    Double terabytes = 0.000000000000125;
    Double petabyte = 0.000000000000000125;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force);

        input_number = (EditText)findViewById(R.id.input);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        btn = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.show);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list1.add("Bits");
        list1.add("Bytes");
        list1.add("Kilobytes");
        list1.add("Megabytes");
        list1.add("Gigabytes");
        list1.add("Terabytes");
        list1.add("Petabytes");

        list2.add("Bits");
        list2.add("Bytes");
        list2.add("Kilobytes");
        list2.add("Megabytes");
        list2.add("Gigabytes");
        list2.add("Terabytes");
        list2.add("Petabytes");

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
                    var1 = bit;
                }
                if (position == 1) {
                    var1 = bytes;
                }
                if (position == 2) {
                    var1 = kilobytes;
                }
                if (position == 3) {
                    var1 = megabytes;
                }
                if (position == 4) {
                    var1 = gigabytes;
                }
                if (position == 5) {
                    var1 = terabytes;
                }
                if (position == 6) {
                    var1 = petabyte;
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
                    var2 = bit;
                }
                if (position == 1) {
                    var2 = bytes;
                }
                if (position == 2) {
                    var2 = kilobytes;
                }
                if (position == 3) {
                    var2 = megabytes;
                }
                if (position == 4) {
                    var2 = gigabytes;
                }
                if (position == 5) {
                    var2 = terabytes;
                }
                if (position == 6) {
                    var2 = petabyte;
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
                output = bit / var1;
                output = output * var2;
                output = output * no;
                if (var2 == bit) {
                    scale = 0;
                }
                if (var2 == bytes) {
                    scale = 1;
                }
                if (var2 == kilobytes) {
                    scale = 2;
                }
                if (var2 == megabytes) {
                    scale = 3;
                }
                if (var2 == gigabytes) {
                    scale = 4;
                }
                if (var2 == terabytes) {
                    scale = 5;
                }
                if (var2 == petabyte) {
                    scale = 6;
                }

                show_result.setText( output+" "+units[scale]);
            }
        });


    }
}
