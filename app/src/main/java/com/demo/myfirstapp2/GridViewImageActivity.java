package com.demo.myfirstapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.myfirstapp2.Models.ImageGridViewAdapter;

public class GridViewImageActivity extends BaseActivity {

    TextView tvMsg;
    GridView gv;
    TextView tvSoloMsg;
    Integer []mThumbIds;
    ImageGridViewAdapter adapter;
    ImageView ivSoloPicture;
    Button btnBack;
    Bundle myBackupBundle;
    boolean isPressBack = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(!isPressBack)
            super.onCreate(savedInstanceState);
        myBackupBundle = savedInstanceState;
        setContentView(R.layout.activity_grid_view_image);
        tvMsg = (TextView) findViewById(R.id.tvMsg_005);
        mThumbIds = new Integer[] {
                R.drawable.baby1,
                R.drawable.baby2,
                R.drawable.baby3,
                R.drawable.baby4,
                R.drawable.baby5,
                R.drawable.baby6,
                R.drawable.baby7,
                R.drawable.baby8,
                R.drawable.baby9,
        };
        gv = (GridView) findViewById(R.id.gridView_005);
        adapter = new ImageGridViewAdapter(this, mThumbIds);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showdetail(position);
            }
        });

    }
    public void showdetail(int position){
        setContentView(R.layout.solo_picture);
        tvSoloMsg = (TextView)findViewById(R.id.tvSoloMsg_005);
        tvSoloMsg.setText("Image at " + position);
        ivSoloPicture=(ImageView) findViewById(R.id.imgSolo_005);
        ivSoloPicture.setImageResource(mThumbIds[position]);
        btnBack = (Button) findViewById(R.id.btnBack_005);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPressBack = true;
                onCreate(myBackupBundle);
            }
        });
    }
}
