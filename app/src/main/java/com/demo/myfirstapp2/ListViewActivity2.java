package com.demo.myfirstapp2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewActivity2 extends BaseActivity {

    EditText txtTen;
    TextView textView1, txtSelection;
    Button btnNhap;
    ListView lvperson;
    ArrayList<String> arrayList = null;
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        txtTen = (EditText)findViewById(R.id.txtTen);
        textView1 = (TextView)findViewById(R.id.textView1);
        txtSelection = (TextView)findViewById(R.id.txtselection2);
        lvperson = (ListView)findViewById(R.id.lvperson);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        arrayList = new ArrayList<String>();
        setSourceListView();
    }

    private void setSourceListView(){
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lvperson.setAdapter(adapter);
        lvperson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtSelection.setText("position : " + position + "; value =" + arrayList.get(position));
            }
        });

        lvperson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showDialogRemoveItem(position);
                return false;
            }
        });

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(txtTen.getText()+"");
                adapter.notifyDataSetChanged();
                clearInputName();
            }
        });
    }

    void clearInputName(){
        txtTen.setText("");
    }
    void showDialogRemoveItem(final int position){
        String personName = arrayList.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to remove " +personName+"?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        arrayList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("No", null);
        AlertDialog alert = builder.create();
        alert.show();
    }
}
