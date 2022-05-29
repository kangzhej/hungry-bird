package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    Button btn3;    //testing
    private Object AdapterView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_out);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);

        btn3 = (Button) findViewById(R.id.button3); //testing

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        btn3.setOnClickListener(this);  //testing


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, login.class);
                startActivity(intent);

            break;
            case R.id.button2:
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this, RegitserActivity.class);
                startActivity(intent2);
                break;

            case R.id.button3:
                Intent intent3 = new Intent();
                intent3.setClass(MainActivity.this,Discover_page.class);
                startActivity(intent3);
                break;

            default:
                break;
        }
    }

}