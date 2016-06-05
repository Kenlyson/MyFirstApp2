package com.demo.myfirstapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.demo.myfirstapp2.Models.Category;
import com.demo.myfirstapp2.Models.MyConst;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listCategory;
    ArrayAdapter<Category> adapter;
    ArrayList<Category> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
    }

    private void initial(){
        listCategory = (ListView) findViewById(R.id.listCategory);
        arrayList = new ArrayList<Category>();
        addCategoryItem();
        adapter = new ArrayAdapter<Category>(this, android.R.layout.simple_list_item_1, arrayList);

        //set dataSource for listView
        listCategory.setAdapter(adapter);
        listCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category cat = arrayList.get(position);
                cat.onRedirect();
            }
        });
    }

    private void addCategoryItem(){
        arrayList.add(new Category("Action bar", MyConst.ACTION_BAR, this, ActionBarClip.class));
        arrayList.add(new Category("List view type 1", MyConst.LIST_VIEW1, this, ListViewActivity.class));
        arrayList.add(new Category("List view type 2",MyConst.LIST_VIEW2, this, ListViewActivity2.class));
        arrayList.add(new Category("My activity", MyConst.MY_ACTIVITY, this, MyActivity.class));
        arrayList.add(new Category("Action menu", MyConst.OPTION_MENU_CONTEXT_MENU, this, SubMenuAndContextMenu.class));
        arrayList.add(new Category("Custom ListView", MyConst.CUSTOM_LISTVIEW, this, CustomListViewActivity.class));
        arrayList.add(new Category("Simple spinner", MyConst.SIMPLE_SPINNER, this, SimpleSpinnerActivity.class));
        arrayList.add(new Category("Spinner and ListView", MyConst.SPINNER_LISTVIEW, this, SpinnerAndListViewActivity.class));
        arrayList.add(new Category("Autocomplete and MultiAutoComlete", MyConst.AUTO_AUTOMULTICOMPLETE_TEXTVIEW, this, AutoAndMultiAutoActivity.class));
    }


}
