package com.demo.myfirstapp2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.demo.myfirstapp2.Models.Employee;
import com.demo.myfirstapp2.Models.EmployeeAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends BaseActivity {
    EditText txtEmpName;
    RadioGroup groupGender;
    ListView lvEmp;
    TextView lblResult;
    CheckBox ckbRemoveAll;
    Button btnAddEmp;
    List<Employee> listEmployees;
    ArrayAdapter<Employee> adapter;
    Boolean isAdd = true;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        txtEmpName = (EditText) findViewById(R.id.txtEmpName);
        groupGender = (RadioGroup) findViewById(R.id.radGroupGender);
        lvEmp = (ListView) findViewById(R.id.lvEmp);
        lblResult = (TextView) findViewById(R.id.lblResult);
        ckbRemoveAll = (CheckBox) findViewById(R.id.ckbRemoveAll);
        ckbRemoveAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for (Employee item : listEmployees) {
                    item.setDelete(isChecked);
                }
                adapter.notifyDataSetChanged();
            }
        });
        btnAddEmp = (Button) findViewById(R.id.btnAddEmp);
        btnAddEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = (listEmployees.size() + 1) + "";
                String name = txtEmpName.getText().toString();

                clearForm();
                if (isAdd) {
                    Employee newEmp = new Employee(id, name, groupGender.getCheckedRadioButtonId() == R.id.radNam);
                    listEmployees.add(newEmp);
                    adapter.notifyDataSetChanged();
                } else if (selectedIndex > -1){
                    Employee newEmp = listEmployees.get(selectedIndex);
                    newEmp.setName(name);
                    newEmp.setGender(groupGender.getCheckedRadioButtonId() == R.id.radNam);
                    adapter.notifyDataSetChanged();
                    isAdd = true;
                    btnAddEmp.setText("Nhập NV");
                }
                onUnSelectedEmployee();

            }
        });
        lvEmp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.YELLOW);
                onSelectedEmployee(position);
                return true;
            }
        });
        lvEmp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.TRANSPARENT);
                onUnSelectedEmployee();

            }
        });
        getListEmployee();
        fillDataSource();

    }

    private void clearForm() {
        txtEmpName.setText("");
    }

    protected void onDeleteSelectedClicked(View view) {
        List<Employee> newlistEmployees = new ArrayList<>();
        for(Employee emp : listEmployees){
            if(!emp.isDelete()){
                newlistEmployees.add(emp);
            }
        }
        listEmployees = newlistEmployees;

        ckbRemoveAll.setChecked(false);
        fillDataSource();
        //adapter.notifyDataSetChanged();
    }

    void getListEmployee() {
        listEmployees = new ArrayList<>();
        listEmployees.add(new Employee("ID 1", "son 1", true));
        listEmployees.add(new Employee("ID 2", "son 2", true));
        listEmployees.add(new Employee("ID 3", "son 3", true));
        listEmployees.add(new Employee("ID 4", "son 4", true));
    }

    void fillDataSource() {
        adapter = new EmployeeAdapter(this, R.layout.employee_item, listEmployees);
        lvEmp.setAdapter(adapter);
    }
    void onSelectedEmployee(int position){
        selectedIndex = position;
        isAdd = false;
        btnAddEmp.setText("Cập nhật");
        Employee emp = listEmployees.get(position);
        txtEmpName.setText(emp.getName());
        groupGender.check(emp.isGender() ? R.id.radNam: R.id.radNu);
    }
    public void onUnSelectedEmployee(){
        selectedIndex = -1;
        isAdd = true;
        btnAddEmp.setText("Nhập NV");
        clearForm();
    }

}
