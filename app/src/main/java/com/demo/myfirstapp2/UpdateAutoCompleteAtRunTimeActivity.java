package com.demo.myfirstapp2;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.demo.myfirstapp2.Models.AutoCompleteRuntime.StudenAdapter;
import com.demo.myfirstapp2.Models.AutoCompleteRuntime.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UpdateAutoCompleteAtRunTimeActivity extends BaseActivity {

    ListView lvSinhvien;
    List<Student> arrSinhvien = new ArrayList<>();
    StudenAdapter adapterSinhvien;

    EditText editMa,editTen,editNamsinh;
    CheckBox chkGender;
    Button btnNamsinh, btnNhapsv;


    AutoCompleteTextView autoTextNs;
    List<String> arrAuto = new ArrayList<>();
    ArrayAdapter<String> adapterAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_auto_complete_at_runtime);
        getFormWidgets();
        addEventsForWidgets();
    }

    private void addEventsForWidgets() {
        btnNamsinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processBirthday();
            }
        });

        btnNhapsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewStudent();
            }
        });
    }

    private void addNewStudent() {
        SimpleDateFormat dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String ma = editMa.getText().toString();
        String ten = editTen.getText().toString();
        String ns = editNamsinh.getText().toString();
        String nois = autoTextNs.getText().toString();
        boolean gt = chkGender.isChecked();
        try{
            Student s = new Student(ma,ten,gt,dft.parse(ns),nois);
            arrSinhvien.add(s);
            adapterSinhvien.notifyDataSetChanged();
            addNewAutoCompleteKeyWord(nois);
        }catch (ParseException e){

        }

    }

    private void addNewAutoCompleteKeyWord(String key) {
        for(String item : arrAuto){
            if(key.trim().equalsIgnoreCase(item.trim())){
                return;// if exist so stop
            }
        }
        arrAuto.add(key);
        adapterAuto = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrAuto);
        autoTextNs.setAdapter(adapterAuto);
    }

    private void processBirthday() {
        DatePickerDialog dateDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                editNamsinh.setText(dayOfMonth+ "/" + monthOfYear + "/" + year);
            }
        }, 1989, 9, 25);
        dateDialog.setTitle("Birthday");
        dateDialog.show();
    }

    private void getFormWidgets() {
        editMa=(EditText) findViewById(R.id.editMa_003);
        editTen=(EditText) findViewById(R.id.editTen_003);
        editNamsinh=(EditText) findViewById(R.id.editNgaySinh_003);
        chkGender=(CheckBox) findViewById(R.id.chkGt_003);
        autoTextNs=(AutoCompleteTextView) findViewById(R.id.autoCompleteNS_003);
        btnNamsinh=(Button) findViewById(R.id.btnNgaySinh_003);
        btnNhapsv=(Button) findViewById(R.id.btnNhap_003);
        lvSinhvien=(ListView) findViewById(R.id.lvsinhvien_003);

        adapterSinhvien = new StudenAdapter(this,R.layout.sinhvien_item_layout,arrSinhvien);
        lvSinhvien.setAdapter(adapterSinhvien);


    }




}
