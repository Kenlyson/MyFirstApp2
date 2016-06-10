package com.demo.myfirstapp2.Models.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by PCPV on 10-06-16.
 */
public class JobInWeek {
    private String title, desciption;
    private Date dateFinish, hourFinish;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Date getHourFinish() {
        return hourFinish;
    }

    public void setHourFinish(Date hourFinish) {
        this.hourFinish = hourFinish;
    }

    @Override
    public String toString() {
        return this.title + "-"
                + getDateFormat(this.dateFinish)
                + getHourFormat(this.hourFinish);
    }

    public String getDateFormat(Date d){
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(d);
    }

    public String getHourFormat(Date d){
        return new SimpleDateFormat("hh:mm a",Locale.getDefault()).format(d);
    }

    public JobInWeek(String title, String desciption, Date dateFinish, Date hourFinish) {
        this.title = title;
        this.desciption = desciption;
        this.dateFinish = dateFinish;
        this.hourFinish = hourFinish;
    }
}
