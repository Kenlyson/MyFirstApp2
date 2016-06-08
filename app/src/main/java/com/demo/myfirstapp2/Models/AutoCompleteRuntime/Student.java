package com.demo.myfirstapp2.Models.AutoCompleteRuntime;

import com.demo.myfirstapp2.Models.SpinnerAndListView.ObjectBase;

import java.util.Date;

/**
 * Created by PCPV on 06-06-16.
 */
public class Student extends ObjectBase {
    private boolean gender;
    private Date birthday;
    private String placeOfBirth;

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Student(String id, String name, boolean gender, Date birthday, String placeOfBirth) {
        super(id, name);
        this.gender = gender;
        this.birthday = birthday;
        this.placeOfBirth = placeOfBirth;
    }

}
