package com.demo.myfirstapp2.Models.SpinnerAndListView;

/**
 * Created by PCPV on 05-06-16.
 */
public class ObjectBase {
    private String id;
    private String name;

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
    public String toString(){
        return this.id + "-" + this.name;
    }

    public ObjectBase(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObjectBase() {
    }
}
