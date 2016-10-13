package com.example.administrator.trainning1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtnName;
    Button btnAdd,btnLinear,btnFrame;
    ListView  lv;
    ArrayList<String> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnName = (EditText) findViewById(R.id.edtName);
        btnAdd  = (Button) findViewById(R.id.btnAdd);
        btnLinear = (Button) findViewById(R.id.btnLinear);
        btnFrame = (Button) findViewById(R.id.btnFrame);
        lv  = (ListView) findViewById(R.id.lv);
        arr = new ArrayList<String>();
        arr.add("asdasd");
        final ArrayAdapter<String > adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arr);
        lv.setAdapter(adapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtnName.getText().toString().trim() != ""){
                    arr.add(edtnName.getText().toString().trim());
                    adapter.notifyDataSetChanged();

                }
            }
        });
        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                intent.putStringArrayListExtra("arr",arr);
                startActivity(intent);
            }
        });

        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);

                startActivity(intent);
            }
        });
    }
}
