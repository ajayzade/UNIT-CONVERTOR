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

public class Vol extends AppCompatActivity {

    EditText input_number;
    Spinner spinner1,spinner2;
    Button btn;
    TextView show_result;
    List<String> list2;
    List<String> list1;

    String[] units = new String[]{
            "m3","litre","cm3","ml","bbl","gallons","quarts"
    };
    int scale;

    double cubicmeter = 1;
    double litre = 1000;
    double cubiccentimeter = 1000;
    double millilitre = 1000000;
    double barrels = 6.29;
    double gallons = 264.172;
    double quarts = 1056.69;

    double var1,var2;
    double output,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vol);


        input_number = (EditText)findViewById(R.id.input);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        btn = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.show);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list1.add("cubicmeter");
        list1.add("litre");
        list1.add("cubiccentimeter");
        list1.add("millilitre");
        list1.add("barrels");
        list1.add("gallons");
        list1.add("quarts");

        list2.add("cubicmeter");
        list2.add("litre");
        list2.add("cubiccentimeter");
        list2.add("millilitre");
        list2.add("barrels");
        list2.add("gallons");
        list2.add("quarts");

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
                    var1 = cubicmeter;
                }
                if (position == 1) {
                    var1 = litre;
                }
                if (position == 2) {
                    var1 = cubiccentimeter;
                }
                if (position == 3) {
                    var1 = millilitre;
                }
                if (position == 4) {
                    var1 = barrels;
                }
                if (position == 5) {
                    var1 = barrels;
                }
                if (position == 6) {
                    var1 = quarts;
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
                    var2 = cubicmeter;
                }
                if (position == 1) {
                    var2 = litre;
                }
                if (position == 2) {
                    var2 = cubiccentimeter;
                }
                if (position == 3) {
                    var2 = millilitre;
                }
                if (position == 4) {
                    var2 = barrels;
                }
                if (position == 5) {
                    var2 = barrels;
                }
                if (position == 6) {
                    var2 = quarts;
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
                output = cubicmeter / var1;
                output = output * var2;
                output = output * no;
                if (var2 == cubicmeter) {
                    scale = 0;
                }
                if (var2 == litre) {
                    scale = 1;
                }
                if (var2 == cubiccentimeter) {
                    scale = 2;
                }
                if (var2 == millilitre) {
                    scale = 3;
                }
                if (var2 == barrels) {
                    scale = 4;
                }
                if (var2 == gallons) {
                    scale = 5;
                }
                if (var2 == quarts) {
                    scale = 6;
                }

                show_result.setText( output+" "+units[scale]);
            }
        });


    }
}
