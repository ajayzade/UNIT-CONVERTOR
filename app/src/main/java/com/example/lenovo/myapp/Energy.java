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

public class Energy extends AppCompatActivity {

    EditText input_number;
    Spinner spinner1,spinner2;
    Button btn;
    TextView show_result;
    List<String> list2;
    List<String> list1;

    String[] units = new String[] {"J","KJ","KWh","Cal","Hp/h","erg","eV","Watt-s","Watt-h"};

    int scale;

    Double joule = 1.0;
    Double kilojoule = 0.001;
    Double kilowatthour = 0.0000002777;
    Double calorie = 0.0002388459;
    Double Hoarseperhour = 0.0000003776726;
    Double erg = 10000000.0;
    Double electronvolt = 6241506363094000000.0;
    Double wattsecond = 1.0;
    Double watthour = 3600.0;

    Double var1,var2,output,no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy);


        input_number = (EditText)findViewById(R.id.input);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        btn = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.show);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list1.add("Joule");
        list1.add("KiloJoule");
        list1.add("KiloWatthour");
        list1.add("Calorie");
        list1.add("Hoarsepower/h");
        list1.add("Erg");
        list1.add("ElectronVolt");
        list1.add("wattsecond");
        list1.add("watthour");

        list2.add("Joule");
        list2.add("KiloJoule");
        list2.add("KiloWatthour");
        list2.add("Calorie");
        list2.add("Hoarsepower/h");
        list2.add("Erg");
        list2.add("ElectronVolt");
        list2.add("wattsecond");
        list2.add("watthour");

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
                    var1 = joule;
                }
                if (position == 1) {
                    var1 = kilojoule;
                }
                if (position == 2) {
                    var1 = kilowatthour;
                }
                if (position == 3) {
                    var1 = calorie;
                }
                if (position == 4) {
                    var1 = Hoarseperhour;
                }
                if (position == 5) {
                    var1 = erg;
                }
                if (position == 6) {
                    var1 = electronvolt;
                }
                if (position == 7) {
                    var1 = wattsecond;
                }
                if (position == 8){
                    var1 = watthour;
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
                    var2 = joule;
                }
                if (position == 1) {
                    var2 = kilojoule;
                }
                if (position == 2) {
                    var2 = kilowatthour;
                }
                if (position == 3) {
                    var2 = calorie;
                }
                if (position == 4) {
                    var2 = Hoarseperhour;
                }
                if (position == 5) {
                    var2 = erg;
                }
                if (position == 6) {
                    var2 = electronvolt;
                }
                if (position == 7) {
                    var2 = wattsecond;
                }
                if (position == 8){
                    var2 = watthour;
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
                output = joule / var1;
                output = output * var2;
                output = output * no;
                if (var2 == joule) {
                    scale = 0;
                }
                if (var2 == kilojoule) {
                    scale = 1;
                }
                if (var2 == kilowatthour) {
                    scale = 2;
                }
                if (var2 == calorie) {
                    scale = 3;
                }
                if (var2 == Hoarseperhour) {
                    scale = 4;
                }
                if (var2 == erg) {
                    scale = 5;
                }
                if (var2 == electronvolt) {
                    scale = 6;
                }
                if (var2 == wattsecond) {
                    scale = 7;
                }
                if (var2 == watthour){
                    scale = 8;
                }

                show_result.setText( output+" "+units[scale]);
            }
        });




    }
}
