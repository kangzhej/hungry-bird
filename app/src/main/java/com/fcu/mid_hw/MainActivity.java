package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static boolean VALID_USER = false;

    Button btn1, btn2;
    Button btn3, btn4, btn5;    //testing
    private Object AdapterView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_out);

        ImageView logo = this.findViewById(R.id.logo);
        logo.setImageResource(R.drawable.logo);

        //if (!VALID_USER){
        //    Intent intent = new Intent();
        //    intent.setClass(this,login.class);
        //    startActivity(intent);
        //}

        btn1 = (Button) findViewById(R.id.next_but);
        btn2 = (Button) findViewById(R.id.button2);

        btn3 = (Button) findViewById(R.id.button3); //testing
        btn4 = (Button) findViewById(R.id.button4); //testing
        btn5 = (Button) findViewById(R.id.button5); //testing

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        btn3.setOnClickListener(this);  //testing
        btn4.setOnClickListener(this);  //testing
        btn5.setOnClickListener(this);  //testing


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

            case R.id.button5:
                Intent intent5 = new Intent();
                intent5.setClass(MainActivity.this, order_list.class);
                startActivity(intent5);
                break;

            default:
                break;
        }
    }

}