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

public class Len extends AppCompatActivity {

    EditText input_number;
    Spinner spinner1,spinner2;
    Button btn;
    TextView show_result;
    List<String> list2;
    List<String> list1;

    String[] units = new String[]{"m",
            "cm","mm","km","mile","yards","foot","inches","nmile"
    };
    int scale;

    double meter = 1;
    double centimeter = 100;
    double millimeter = 1000;
    double kilometer = 0.001;
    double mile = 0.000621371;
    double yard = 1.09361;
    double foot = 3.28084;
    double inch = 39.3701;
    double nauticalmile = 0.000539957;

    double var1,var2;
    double output;
    double no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_len);

        input_number = (EditText)findViewById(R.id.input);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        btn = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.show);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list1.add("meter");
        list1.add("centimeter");
        list1.add("millimeter");
        list1.add("kilometer");
        list1.add("mile");
        list1.add("yard");
        list1.add("foot");
        list1.add("inch");
        list1.add("nauticalmile");

        list2.add("meter");
        list2.add("centimeter");
        list2.add("millimeter");
        list2.add("kilometer");
        list2.add("mile");
        list2.add("yard");
        list2.add("foot");
        list2.add("inch");
        list2.add("nauticalmile");

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
                    var1 = meter;
                }
                if (position == 1) {
                    var1 = centimeter;
                }
                if (position == 2) {
                    var1 = millimeter;
                }
                if (position == 3) {
                    var1 = kilometer;
                }
                if (position == 4) {
                    var1 = mile;
                }
                if (position == 5) {
                    var1 = yard;
                }
                if (position == 6) {
                    var1 = foot;
                }
                if (position == 7) {
                    var1 = inch;
                }
                if (position == 8) {
                    var1 = nauticalmile;
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
                    var2 = meter;
                }
                if (position == 1) {
                    var2 = centimeter;
                }
                if (position == 2) {
                    var2 = millimeter;
                }
                if (position == 3) {
                    var2 = kilometer;
                }
                if (position == 4) {
                    var2 = mile;
                }
                if (position == 5) {
                    var2 = yard;
                }
                if (position == 6) {
                    var2 = foot;
                }
                if (position == 7) {
                    var2 = inch;
                }
                if (position == 8) {
                    var2 = nauticalmile;
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
                no = Double.parseDouble(value);
                output = meter / var1;
                output = output * var2;
                output = output * no;
                if (var2 == meter) {
                    scale = 0;
                }
                if (var2 == centimeter) {
                    scale = 1;
                }
                if (var2 == millimeter) {
                    scale = 2;
                }
                if (var2 == kilometer) {
                    scale = 3;
                }
                if (var2 == mile) {
                    scale = 4;
                }
                if (var2 == yard) {
                    scale = 5;
                }
                if (var2 == foot) {
                    scale = 6;
                }
                if (var2 == inch) {
                    scale = 7;
                }
                if (var2 == nauticalmile) {
                    scale = 8;
                }



                show_result.setText( output+" "+units[scale]);
            }
        });


    }
}
