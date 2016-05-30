package com.demo.myfirstapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.demo.myfirstapp2.Models.Employee;
import com.demo.myfirstapp2.Models.EmployeeApdater;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends BaseActivity {
    EditText txtEmpId, txtEmpName;
    RadioGroup groupGender;
    ListView lvEmp;
    TextView lblResult;
    List<Employee> listEmployees;
    ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        txtEmpId = (EditText) findViewById(R.id.txtEmpId);
        txtEmpName = (EditText) findViewById(R.id.txtEmpName);
        groupGender = (RadioGroup) findViewById(R.id.radGroupGender);
        lvEmp = (ListView) findViewById(R.id.lvEmp);
        lblResult =(TextView) findViewById(R.id.lblResult);
        getListEmployee();
        fillDataSource();

    }

    protected void onDeleteSelectedClicked(View view){

        for(Employee item : listEmployees){
            if(item.isDelete())
                listEmployees.remove(item);
        }
//        for(int i=lvEmp.getChildCount()-1;i>=0;i--)
//        {
//            View v=lvEmp.getChildAt(i);
//            CheckBox chk=(CheckBox) v.findViewById(R.id.chkitem);
//            if(chk.isChecked())
//            {
//                listEmployees.remove(i);
//            }
//        }
        adapter.notifyDataSetChanged();
    }

    void getListEmployee(){
        listEmployees = new ArrayList<>();
        listEmployees.add(new Employee("ID 1", "son 1", true));
        listEmployees.add(new Employee("ID 2", "son 2", true));
        listEmployees.add(new Employee("ID 3", "son 3", true));
        listEmployees.add(new Employee("ID 4", "son 4", true));
    }

    void fillDataSource(){
        adapter = new EmployeeApdater(this,R.layout.employee_item, listEmployees);
        lvEmp.setAdapter(adapter);
    }

}
