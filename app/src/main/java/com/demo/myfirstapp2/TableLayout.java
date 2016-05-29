package com.demo.myfirstapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TableLayout extends BaseActivity {
    TextView lblResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        lblResult = (TextView)findViewById(R.id.lblResult);
        lblResult.setText(getIntent().getExtras().getString("son1"));
    }

    protected void onBack(){
        startActivity(new Intent(this, MyActivity.class));
        TableLayout.this.finish();
    }
}
