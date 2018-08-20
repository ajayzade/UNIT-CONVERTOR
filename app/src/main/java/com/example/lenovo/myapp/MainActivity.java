package com.example.lenovo.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ListView first;

    int[] IMAGES = new int[] {R.drawable.length,R.drawable.weight,R.drawable.area,R.drawable.volume,
    R.drawable.speed,R.drawable.time,R.drawable.storage,R.drawable.pressure,R.drawable.energy,R.drawable.angle};

    String[] Names = {"LENGTH CONVERTER","WEIGHT CONVERTER","AREA CONVERTER","VOLUME CONVERTER",
            "SPEED CONVERTER","TIME CONVERTER","STORAGE UNIT CONVERTER","PRESSURE CONVERTER",
            "ENERGY CONVERTER","ANGLE CONVERTER"
    };

    String[] Description = new String[] {"9 types","8 types","6 types","7 types","5 types","7 types","7 types","5 types",
            "9 types","7 types",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (ListView)findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();

        first.setAdapter(customAdapter);

        first.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent one = new Intent(MainActivity.this,Len.class);
                    startActivity(one);
                }
                if(position == 1){
                    Intent two = new Intent(MainActivity.this,Wei.class);
                    startActivity(two);
                }
                if(position == 2){
                    Intent three = new Intent(MainActivity.this,Are.class);
                    startActivity(three);
                }
                if(position == 3){
                    Intent four = new Intent(MainActivity.this,Vol.class);
                    startActivity(four);
                }
                if(position == 4){
                    Intent five = new Intent(MainActivity.this,Spe.class);
                    startActivity(five);
                }
                if(position == 5){
                    Intent six = new Intent(MainActivity.this,Tim.class);
                    startActivity(six);
                }
                if (position == 6){
                    Intent seven = new Intent(MainActivity.this,Force.class);
                    startActivity(seven);
                }
                if (position == 7){
                    Intent eight = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(eight);
                }
                if (position == 8){
                    Intent nine = new Intent(MainActivity.this,Energy.class);
                    startActivity(nine);
                }
                if (position == 9){
                    Intent ten = new Intent(MainActivity.this,Angle.class);
                    startActivity(ten);
                }
            }
        });


    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            TextView names = (TextView) convertView.findViewById(R.id.textView3);
            TextView description = (TextView) convertView.findViewById(R.id.textView4);

            imageView.setImageResource(IMAGES[position]);
            names.setText(Names[position]);
            description.setText(Description[position]);
            return convertView;
        }
    }
}
