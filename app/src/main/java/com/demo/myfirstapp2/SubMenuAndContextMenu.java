package com.demo.myfirstapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SubMenuAndContextMenu extends BaseActivity {
    EditText txtXinChao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_and_context_menu);
        txtXinChao = (EditText) findViewById(R.id.txtXinChao);
        registerForContextMenu(txtXinChao);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        addMenuItems(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        addMenuItems(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.onClickMenuItem(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        this.onClickMenuItem(item);
        return super.onContextItemSelected(item);
    }

    protected void onClickMenuItem(MenuItem item){
        if(item.getGroupId() == 0){
            updateTextSize(item);
        }else if(item.getGroupId() == 2){
            AlertMessage(item.getTitle().toString());
        }
    }

    private void addMenuItems(Menu menu){
        for (int i=0; i < 5; i ++){
            int supIndex = i + 1;
            String content = (supIndex * 10) +" Points";
            menu.add(0, supIndex, supIndex * 10, content);
        }
        addSubMenu(menu);
    }

    private void addSubMenu(Menu menu){
        SubMenu child = menu.addSubMenu(1, 6, 60, "Tính năng");
        child.add(2, 7, 1, "Copy");
        child.add(2, 8, 2, "Paste");
        child.add(2, 9, 3, "Cut");
    }
    private void updateTextSize(MenuItem item){
        txtXinChao.setTextSize(item.getOrder());
    }

    private void AlertMessage(String mess){
        Toast.makeText(getApplicationContext(), mess, Toast.LENGTH_SHORT).show();
    }
}
