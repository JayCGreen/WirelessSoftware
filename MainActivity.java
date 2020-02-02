package com.example.temp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText farentext, celtext;
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        farentext = findViewById(R.id.ftxt);
        celtext = findViewById(R.id.ctxt);
        

        //Type int the Fahrenheit to change the Celsius

        farentext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (farentext.hasFocus()) {
                    String ftxt = farentext.getText().toString();
                    if (ftxt.length() > 0) {
                        int fdegree = Integer.parseInt(ftxt);
                        int cdegree = (fdegree - 32) * 5 / 9;
                        celtext.setText("" + cdegree);
                    } else {
                        celtext.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        //Type in Celsius block to change the Fahrenheit automatically

        celtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (celtext.hasFocus()) {
                    String ctxt = celtext.getText().toString();
                    if (ctxt.length() > 0) {
                        int cdegree = Integer.parseInt(ctxt);
                        int fdegree = (cdegree * 9 / 5) + 32;
                        farentext.setText("" + fdegree);
                    } else {
                        farentext.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });








    }


}
