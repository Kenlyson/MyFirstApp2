package com.demo.myfirstapp2.Models.SpinnerAndListView;

/**
 * Created by PCPV on 05-06-16.
 */
public class Product extends ObjectBase {
    private Category Dmuc;

    public Category getDmuc() {
        return Dmuc;
    }

    public void setDmuc(Category dmuc) {
        Dmuc = dmuc;
    }

    public Product(String id, String name, Category dmuc) {
        super(id, name);
        Dmuc = dmuc;
    }

    public Product(String id, String name) {
        super(id, name);
    }
}
