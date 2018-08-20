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

public class Wei extends AppCompatActivity {

    EditText input_number;
    Spinner spinner1,spinner2;
    Button btn;
    TextView show_result;
    List<String> list2;
    List<String> list1;

    String[] units = new String[]{
            "kg","g","mg","pound","ounce","stone","metric ton"
    };
    int scale;

    double kilogram = 1;
    double gram = 1000;
    double milligram = 1000000;
    double pound = 2.2;
    double ounce = 35.274;
    double stone = 0.157473;
    double metricton = 0.001;
    double quintal = 0.01;

    double var1,var2;
    double output,no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wei);

        input_number = (EditText)findViewById(R.id.input);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        btn = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.show);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list1.add("kilogram");
        list1.add("gram");
        list1.add("milligram");
        list1.add("pound");
        list1.add("ounces");
        list1.add("stone");
        list1.add("metric ton");
        list1.add("quintal");

        list2.add("kilogram");
        list2.add("gram");
        list2.add("milligram");
        list2.add("pound");
        list2.add("ounces");
        list2.add("stone");
        list2.add("metric ton");
        list2.add("quintal");

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
                    var1 = kilogram;
                }
                if (position == 1) {
                    var1 = gram;
                }
                if (position == 2) {
                    var1 = milligram;
                }
                if (position == 3) {
                    var1 = pound;
                }
                if (position == 4) {
                    var1 = ounce;
                }
                if (position == 5) {
                    var1 = stone;
                }
                if (position == 6) {
                    var1 = metricton;
                }
                if (position == 7) {
                    var1 = quintal;
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
                    var2 = kilogram;
                }
                if (position == 1) {
                    var2 = gram;
                }
                if (position == 2) {
                    var2 = milligram;
                }
                if (position == 3) {
                    var2 = pound;
                }
                if (position == 4) {
                    var2 = ounce;
                }
                if (position == 5) {
                    var2 = stone;
                }
                if (position == 6) {
                    var2 = metricton;
                }
                if (position == 7) {
                    var2 = quintal;
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
                output = kilogram / var1;
                output = output * var2;
                output = output * no;
                if (var2 == kilogram) {
                    scale = 0;
                }
                if (var2 == gram) {
                    scale = 1;
                }
                if (var2 == milligram) {
                    scale = 2;
                }
                if (var2 == pound) {
                    scale = 3;
                }
                if (var2 == ounce) {
                    scale = 4;
                }
                if (var2 == stone) {
                    scale = 5;
                }
                if (var2 == metricton) {
                    scale = 6;
                }
                if (var2 == quintal) {
                    scale = 7;
                }

                show_result.setText( output+" "+units[scale]);
            }
        });


    }
}
