package com.demo.myfirstapp2.Models;

/**
 * Created by Kenlsyon on 31-05-16.
 */
public class Employee {
    private String id;
    private String name;
    private boolean gender;
    private boolean isDelete;

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return this.id+"-"+this.name;
    }

    public Employee(String id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.isDelete = false;
    }
}
