package com.demo.myfirstapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MyActivity extends BaseActivity {
    EditText txtUser;
    EditText txtPassword;
    Button btnLogin;
    TextView lblResult;
    int screenHeight, screenWidth;

    RadioButton radio_male, radio_female, radio_unknowSex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initial();

    }

    public void initial(){
        initScreenSize();
        initControlTextBox();
        initControlRadioButton();
    }

    public void initControlTextBox(){
        txtUser = (EditText)findViewById(R.id.txtUserName);
        txtPassword= (EditText)findViewById(R.id.txtPass);
        lblResult = (TextView) findViewById(R.id.lblResult);
        btnLogin = (Button)findViewById(R.id.btnSubmit);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUser.getText().length() == 0){
                    lblResult.setText("You have to press your user name");
                }else if(txtPassword.getText().length() == 0){
                    lblResult.setText("You have to press your password");
                }else{
                    lblResult.setText("Successfull !! Your user name : "+txtUser.getText()
                            +"; Pass: "+txtPassword.getText()+"");
                }
            }
        });
    }

    public void initControlRadioButton(){
        radio_male = (RadioButton) findViewById(R.id.radio_male);
        radio_male.setSelected(true);
        radio_female = (RadioButton) findViewById(R.id.radio_female);
        radio_unknowSex = (RadioButton) findViewById(R.id.radio_unknowSex);
        radio_male.setWidth(screenWidth/3);
        radio_female.setWidth(screenWidth/3);
        radio_unknowSex.setWidth(screenWidth/3);
    }

    public void initScreenSize(){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeight = displaymetrics.heightPixels;
        screenWidth = displaymetrics.widthPixels;
    }


    public void onExit(View v){
        lblResult.setText("exit app");
        Intent intent = new Intent(this,TableLayout.class);
        Bundle bundle = new Bundle();
        bundle.putString("son1", "kaka");
        bundle.putString("son2", "kaka 2");
        intent.putExtras(bundle);
        this.finish();
        startActivity(intent, bundle);

    }

    protected void onRadioButtonClicked(View v){
        switch (v.getId()){
            case R.id.radio_male:
                lblResult.setText("radio_male");
                break;
            case R.id.radio_female:
                lblResult.setText("radio_female");
                break;
            case R.id.radio_unknowSex:
                lblResult.setText("radio_unknowSex");
                break;
            default:
                lblResult.setText("fail");
                break;
        }
    }
}
