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

public class Are extends AppCompatActivity {

    EditText input_number;
    Spinner spinner1,spinner2;
    Button btn;
    TextView show_result;
    List<String> list2;
    List<String> list1;

    String[] units = new String[]{
            "sq km","sq m","sq mile","sq yard","acre","hectere"
    };
    int scale;

    double sqkm = 1;
    double sqm = 1000000;
    double sqmile = 0.386102;
    double sqyard = 1196000;
    double acre = 247.105;
    double hectere = 100;

    double var1,var2;
    double output,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_are);

        input_number = (EditText)findViewById(R.id.input);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        btn = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.show);
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();

        list1.add("sq kilometer");
        list1.add("sq meter");
        list1.add("sq mile");
        list1.add("sq yard");
        list1.add("acre");
        list1.add("hectere");

        list2.add("sq kilometer");
        list2.add("sq meter");
        list2.add("sq mile");
        list2.add("sq yard");
        list2.add("acre");
        list2.add("hectere");

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
                    var1 = sqkm;
                }
                if (position == 1) {
                    var1 = sqm;
                }
                if (position == 2) {
                    var1 = sqmile;
                }
                if (position == 3) {
                    var1 = sqyard;
                }
                if (position == 4) {
                    var1 = acre;
                }
                if (position == 5) {
                    var1 = hectere;
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
                    var2 = sqkm;
                }
                if (position == 1) {
                    var2 = sqm;
                }
                if (position == 2) {
                    var2 = sqmile;
                }
                if (position == 3) {
                    var2 = sqyard;
                }
                if (position == 4) {
                    var2 = acre;
                }
                if (position == 5) {
                    var2 = hectere;
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
                output = sqkm / var1;
                output = output * var2;
                output = output * no;
                if (var2 == sqkm) {
                    scale = 0;
                }
                if (var2 == sqm) {
                    scale = 1;
                }
                if (var2 == sqmile) {
                    scale = 2;
                }
                if (var2 == sqyard) {
                    scale = 3;
                }
                if (var2 == acre) {
                    scale = 4;
                }
                if (var2 == hectere) {
                    scale = 5;
                }


                show_result.setText( output+" "+units[scale]);
            }
        });


    }
}
