package com.demo.myfirstapp2.Models.AutoCompleteRuntime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.demo.myfirstapp2.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by PCPV on 06-06-16.
 */
public class StudenAdapter extends ArrayAdapter<Student> {

    Context context;
    int resourceId;
    List<Student> listStudent;
    public StudenAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceId = resource;
        this.listStudent = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resourceId, null);
        }
        TextView txtMaTen = (TextView) convertView.findViewById(R.id.txtMaVaTen_003);
        TextView txtKhac = (TextView) convertView.findViewById(R.id.txtThongTinKhac_003);
        Student s = listStudent.get(position);
        txtMaTen.setText(s.getId() + " - " + s.getName());
        SimpleDateFormat dft = new SimpleDateFormat("dd/mm/yyyy", Locale.getDefault());
        String sex = s.isGender() ? "Nữ" : "Nam";
        String DOB = dft.format(s.getBirthday());
        String placeBD = s.getPlaceOfBirth();
        txtKhac.setText(sex + "-" + DOB + "-" + placeBD);
        return convertView;
    }
}
