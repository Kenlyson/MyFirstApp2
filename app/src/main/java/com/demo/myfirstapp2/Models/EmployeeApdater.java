package com.demo.myfirstapp2.Models;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.myfirstapp2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PCPV on 31-05-16.
 */
public class EmployeeApdater extends ArrayAdapter<Employee> {
    Context _context;
    int _layoutId;
    List<Employee> _listEmployee;
    public EmployeeApdater(Context context, int resource, List<Employee> objects) {
        super(context, resource, objects);
        this._context = context;
        this._layoutId = resource;
        this._listEmployee = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater )_context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(_layoutId, null);

        final TextView txtdisplay=(TextView)
                convertView.findViewById(R.id.txtitem);

        final Employee emp=_listEmployee.get(position);

        txtdisplay.setText(emp.toString());
        final ImageView imgitem=(ImageView)
                convertView.findViewById(R.id.imgitem);
        if(emp.isGender())
            imgitem.setImageResource(R.mipmap.male);
        else
            imgitem.setImageResource(R.mipmap.female );


        final CheckBox chkitem=(CheckBox)
                convertView.findViewById(R.id.chkitem);
        chkitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = ((CheckBox)v).isChecked();
                emp.setDelete(isChecked);
            }
        });

        return convertView;

    }
}
