package com.demo.myfirstapp2.Models;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Kenlyson on 29-05-16.
 */
public class Category {
    private String _name;
    private String _value;
    private Context _curentContext;
    private Class<?> _nextCls;
    public Context get_curentContext() {
        return _curentContext;
    }

    public void set_curentContext(Context _curentContext) {
        this._curentContext = _curentContext;
    }





    public Class<?> get_nextCls() {
        return _nextCls;
    }

    public void set_nextCls(Class<?> _nextCls) {
        this._nextCls = _nextCls;
    }



    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_value() {
        return _value;
    }

    public void set_value(String _value) {
        this._value = _value;
    }

    public Category(String _name, String _value, Context _curentContext, Class<?> _nextCls) {
        this._name = _name;
        this._value = _value;
        this._curentContext = _curentContext;
        this._nextCls = _nextCls;
    }

    public void onRedirect(){
        Intent intent = new Intent(get_curentContext(), get_nextCls());
        this.get_curentContext().startActivity(intent);
    }

    @Override
    public String toString() {
        return get_name();
    }
}
