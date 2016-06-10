package com.demo.myfirstapp2.Models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by PCPV on 10-06-16.
 */
public class Helper {

    public static final String HOUR24  = "HH:mm:ss";
    public static final String HOUR12  = "hh:mm:ss a";
    public static final String DATE  = "dd/MM/yyyy";
    public static final String FULL_DATE_TIME_12  = "dd/MM/yyyy hh:mm:ss a";
    public static final String FULL_DATE_TIME_24  = "dd/MM/yyyy HH:mm:ss";

    Calendar now = null;
    public Helper(){
        now = Calendar.getInstance();
    }

    private SimpleDateFormat getDateFormat(String strFormat){
        return new SimpleDateFormat(strFormat);
    }

    public String getStrDate(Date date){
        return getDateFormat(DATE).format(date);
    }

    public String getStrDate_hh_mm_ss12(Date date){
        return getDateFormat(HOUR12).format(date);
    }

    public String getStrDate_hh_mm_ss24(Date date){
        return getDateFormat(HOUR24).format(date);
    }
    

    public String getCurrentDateTime12(){
        return getStrDate_hh_mm_ss12(new Date());
    }

    public String getCurrentDateTime24(String type){
        return getStrDate_hh_mm_ss24(new Date());
    }

    public String getFullDateTime_12(String typeHour){
        return getDateFormat(FULL_DATE_TIME_12).format(now.getTime());
    }

    public int getCurrentYear(){
        return now.get(Calendar.YEAR);
    }

    public int getCurrentMonth(){
        return now.get(Calendar.MONTH) + 1;
    }

    public int getCurrentDate(){
        return now.get(Calendar.DATE);
    }
}

