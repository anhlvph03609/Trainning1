package com.example.administrator.trainning1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class LinearLayoutActivity extends AppCompatActivity {
    EditText edtnName;
    Button btnAdd,btnLinear;
    ListView lv;
    ArrayList<String> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        edtnName = (EditText) findViewById(R.id.edt);
        btnAdd  = (Button) findViewById(R.id.Add);


        lv  = (ListView) findViewById(R.id.lv);
        arr = new ArrayList<String>();
        Intent i = getIntent();
        arr = i.getStringArrayListExtra("arr");
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
    }
}
