package com.demo.myfirstapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.demo.myfirstapp2.Models.SpinnerAndListView.*;


import java.util.ArrayList;
import java.util.List;

public class SpinnerAndListViewActivity extends BaseActivity {
    Spinner spinDm;
    EditText editma, editten;
    Button btnNhap;
    ListView lvSp;
    List<Category> arrayPinner = new ArrayList<>();
    ArrayAdapter<Category> adapterPinner = null;

    List<Product> arrayProduct = new ArrayList<>();
    ArrayAdapter<Product> adapterProduct = null;

    Category seletedCategory = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_and_list_view);
        initControl();
        fakeDataCategory();
        onCategoryChanged();
        onBtnAddClicked();
    }

    protected void initControl(){
        spinDm =(Spinner)findViewById(R.id.spinnerCategory_001);
        editma = (EditText) findViewById(R.id.txtProductId_001);
        editten = (EditText) findViewById(R.id.txtProductName_001);
        btnNhap = (Button) findViewById(R.id.btnAdd_001);
        lvSp = (ListView) findViewById(R.id.lvProduct_001);

        adapterPinner = new ArrayAdapter<Category>(this,android.R.layout.simple_spinner_dropdown_item,arrayPinner);
        spinDm.setAdapter(adapterPinner);

        adapterProduct = new ArrayAdapter<Product>(this,android.R.layout.simple_list_item_1, arrayProduct);
        lvSp.setAdapter(adapterProduct);
    }

    protected void fakeDataCategory(){
        arrayPinner.add(new Category("1","Samsung"));
        arrayPinner.add(new Category("2","Iphone"));
        arrayPinner.add(new Category("3","Ipad"));
        adapterPinner.notifyDataSetChanged();
    }

    protected void onCategoryChanged(){
        spinDm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seletedCategory = arrayPinner.get(position);
                reloadLoadListProduct();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    protected void reloadLoadListProduct(){
        arrayProduct.clear();
        arrayProduct.addAll(seletedCategory.getListProduct());
        adapterProduct.notifyDataSetChanged();
        clearForm();
    }

    protected void onBtnAddClicked(){
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seletedCategory.addNewProduct(
                        new Product(
                                editma.getText().toString(),
                                editten.getText().toString())
                );
                reloadLoadListProduct();
            }
        });
    }

    void clearForm(){
        editten.setText("");
        editma.setText("");
    }

}
