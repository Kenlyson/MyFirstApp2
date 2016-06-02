package com.demo.myfirstapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends BaseActivity {
    TextView txtSelection;
    ListView lvPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        txtSelection = (TextView) findViewById(R.id.txtSelection);
        lvPerson = (ListView) findViewById(R.id.lvPerson);
        setDataSoureForListPerson();
    }

    private void setDataSoureForListPerson(){
        final String arr[] = {"name 1", "name 2", "name 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0,
                                            View arg1,
                                            int rowID,
                                            long arg3) {
                        //đối số arg2 là vị trí phần tử trong Data Source (arr)
                        txtSelection.setText("position :"+rowID+" ; value ="+arr[rowID]);
                    }
                }
        );
    }


}
