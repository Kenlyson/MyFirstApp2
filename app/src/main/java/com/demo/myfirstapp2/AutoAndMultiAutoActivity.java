package com.demo.myfirstapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class AutoAndMultiAutoActivity extends BaseActivity {

    TextView selection;
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;
    String arr[]={"hà nội","Huế","Sài gòn",
            "hà giang","Hội an","Kiên giang",
            "Lâm đồng","Long khánh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_and_multi_auto);
        selection = (TextView) findViewById(R.id.txtSelection_002);
        singleComplete = (AutoCompleteTextView) findViewById(R.id.editauto_002);
        multiComplete = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoComleteTextView_002);

        singleComplete.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr));
        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                selection.setText(singleComplete.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        multiComplete.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr));
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
//        multiComplete.setTokenizer(new MultiAutoCompleteTextView.Tokenizer() {
//            @Override
//            public int findTokenStart(CharSequence text, int cursor) {
//                return 0;
//            }
//
//            @Override
//            public int findTokenEnd(CharSequence text, int cursor) {
//                return 0;
//            }
//
//            @Override
//            public CharSequence terminateToken(CharSequence text) {
//                return text;
//            }
//        });

    }

}
