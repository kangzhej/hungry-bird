package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class user_Search extends AppCompatActivity {

    static final String db_name="restDB";
    static final String tb_name="info";
    SQLiteDatabase db;

    EditText etname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);

        etname = findViewById(R.id.searchbox);
    }


    public void on_search(View view){

        String name = etname.getText().toString();

        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
        Cursor c=db.rawQuery("SELECT * FROM "+tb_name +"WHERE `name` LIKE"+name,null);


        if(c.moveToFirst()){
            String str="總共有 "+c.getCount()+"筆資料\n" ;
            str+="-----\n";

            do{
                str+="id: " + c.getString(0)+"\n";
                str+="name: " + c.getString(1)+"\n";
                str+="-----\n";
            } while (c.moveToNext());

            TextView txv2=(TextView) findViewById(R.id.txv4);
            txv2.setText(str);

        }





    }


    public void on_discover(View view){

        Intent intent = new Intent();
        intent.setClass(user_Search.this, Discover_page.class);
        startActivity(intent);

    }


    public void on_order(View view){

        Intent intent2 = new Intent();
        intent2.setClass(user_Search.this, order_list.class);
        startActivity(intent2);

    }



}