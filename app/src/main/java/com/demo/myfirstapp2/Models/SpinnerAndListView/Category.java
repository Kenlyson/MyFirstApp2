package com.demo.myfirstapp2.Models.SpinnerAndListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kenlyson on 05-06-16.
 */
public class Category extends ObjectBase {
    private List<Product> listProduct;

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public Category() {
        super();
        listProduct = new ArrayList<>();
    }

    public Category(String id, String name) {
        super(id, name);
        listProduct = new ArrayList<>();
    }

    public boolean isDuplicate(Product p){
        for(Product p1 : listProduct){
            if(p1.getId().trim().equalsIgnoreCase(p.getId().trim())){
                return true;
            }
        }
        return false;
    }

    public boolean addNewProduct(Product p){
        if(isDuplicate(p)){
            return false;
        }else{
            p.setDmuc(this);
            listProduct.add(p);
            return true;
        }
    }

    public int size(){
        return this.listProduct.size();
    }

    public Product getProductByPosition(int position){
        return this.listProduct.get(position);
    }
}
