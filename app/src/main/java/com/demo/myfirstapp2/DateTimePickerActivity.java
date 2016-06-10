package com.demo.myfirstapp2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.job.JobInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateTimePickerActivity extends BaseActivity {
    TextView txtDate, txtTime;
    EditText editCv, editNd;
    Date dateFinish, hourFinish;
    Button btnDate, btnTime, btnAdd;
    ListView lvCv;
    ArrayList<JobInfo> arrJob = new ArrayList<>();
    ArrayAdapter<JobInfo> adapter = null;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);
        getFormWidgets();
        getDefaultInfo();
        addEventFormWidget();
    }

    private void addEventFormWidget() {
        btnDate.setOnClickListener(new MyButtonEvent());
        btnTime.setOnClickListener(new MyButtonEvent());
        btnAdd.setOnClickListener(new MyButtonEvent());
        lvCv.setOnItemClickListener(new MyListViewEvent());
        lvCv.setOnItemLongClickListener(new MyListViewEvent());
    }

    private void getDefaultInfo() {
        calendar = Calendar.getInstance();
        SimpleDateFormat dft ;
        dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        txtDate.setText(dft.format(calendar.getTime()));

        dft = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        txtTime.setText(dft.format(calendar.getTime()));

        dft = new SimpleDateFormat("HH:mm", Locale.getDefault());
        txtTime.setTag(dft.format(calendar.getTime()));
        editCv.requestFocus();

        dateFinish = calendar.getTime();
        hourFinish = calendar.getTime();
    }

    private void getFormWidgets() {
        txtDate = (TextView) findViewById(R.id.txtDate_006);
        txtTime = (TextView) findViewById(R.id.txttime_006);
        editCv = (EditText) findViewById(R.id.editcongviec_006);
        editNd = (EditText) findViewById(R.id.editnoidung_006);
        btnDate = (Button) findViewById(R.id.btndate_006);
        btnTime = (Button) findViewById(R.id.btntime_006);
        btnAdd = (Button) findViewById(R.id.btnAdd_006);
        lvCv = (ListView) findViewById(R.id.lvcongviec_006);

        adapter = new ArrayAdapter<JobInfo>(this, android.R.layout.simple_list_item_1, arrJob);
        lvCv.setAdapter(adapter);
    }

    private class MyButtonEvent implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btndate_006:
                    showDatePickerDialog();
                    break;
                case R.id.btntime_006:
                    showTimePickerDialog();
                    break;
                case R.id.btnAdd_006:
                    processAddJob();
                    break;
            }
        }
    }

    private void processAddJob() {

    }

    public void showTimePickerDialog() {
        TimePickerDialog.OnTimeSetListener callback = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view,
                                  int hourOfDay, int minute) {
                //Xử lý lưu giờ và AM,PM
                String s = hourOfDay + ":" + minute;
                int hourTam = hourOfDay;
                if (hourTam > 12)
                    hourTam = hourTam - 12;
                txtTime.setText(hourTam + ":" + minute + (hourOfDay > 12 ? " PM" : " AM"));
                //lưu giờ thực vào tag
                txtTime.setTag(s);
                //lưu vết lại giờ vào hourFinish
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                hourFinish = calendar.getTime();
            }
        };
        //các lệnh dưới này xử lý ngày giờ trong TimePickerDialog
        //sẽ giống với trên TextView khi mở nó lên
        String s = txtTime.getTag() + "";
        String strArr[] = s.split(":");
        int gio = Integer.parseInt(strArr[0]);
        int phut = Integer.parseInt(strArr[1]);
        TimePickerDialog time = new TimePickerDialog(
                this,
                callback, gio, phut, true);
        time.setTitle("Chọn giờ hoàn thành");
        time.show();
    }

    private void showDatePickerDialog() {
        DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                txtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) +"/" + year );
            }
        };
        String s = txtDate.getText()+"";
        String strArrtmp[] = s.split("/");
        int ngay = Integer.parseInt(strArrtmp[0]);
        int thang = Integer.parseInt(strArrtmp[1]);
        int nam = Integer.parseInt(strArrtmp[2]);

        DatePickerDialog pic = new DatePickerDialog(this, callback,nam, thang, ngay);
        pic.setTitle("Chọn ngày hoàn thành");
        pic.show();

    }

    private class MyListViewEvent implements
            AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener
    {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            return false;
        }
    }
}
