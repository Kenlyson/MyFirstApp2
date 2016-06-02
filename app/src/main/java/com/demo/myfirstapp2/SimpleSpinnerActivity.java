package com.demo.myfirstapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SimpleSpinnerActivity extends BaseActivity {
    String arrCodeLang[] = {
            "C#",
            "Python",
            "React Native",
            "ObjectC",
            "Swift",
            "Java",
            "Javascript",
            "Sql"
    };
    TextView selection;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_spinner);
        initialControl();
        handleSpinner();
    }

    void initialControl(){
        selection = (TextView) findViewById(R.id.selection_simple_spinner);
        spin = (Spinner) findViewById(R.id.spinner1);
    }
    void handleSpinner(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, arrCodeLang);
        //adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection.setText(arrCodeLang[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selection.setText("");
            }
        });
    }
}
