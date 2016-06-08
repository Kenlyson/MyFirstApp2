package com.demo.myfirstapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridViewActivity extends BaseActivity {

    String arr[]={"Ipad","Iphone","New Ipad",
            "SamSung","Nokia","Sony Ericson",
            "LG","Q-Mobile","HTC","Blackberry",
            "G Phone","FPT - Phone","HK Phone"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        final TextView selection = (TextView) findViewById(R.id.selection_004);
        GridView gv = (GridView) findViewById(R.id.gridView1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, arr);
        gv.setAdapter(arrayAdapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selection.setText(arr[position]);
            }
        });
    }
}
