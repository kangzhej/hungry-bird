package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    Button btn3, btn4;    //testing
    private Object AdapterView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_out);

        btn1 = (Button) findViewById(R.id.next_but);
        btn2 = (Button) findViewById(R.id.button2);

        btn3 = (Button) findViewById(R.id.button3); //testing
        btn4 = (Button) findViewById(R.id.button4); //testing

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        btn3.setOnClickListener(this);  //testing
        btn4.setOnClickListener(this);  //testing


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_but:

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


            case R.id.button4:
                Intent intent4 = new Intent();
                intent4.setClass(MainActivity.this,Profile_page.class);
                startActivity(intent4);
                break;

            default:
                break;
        }
    }

}