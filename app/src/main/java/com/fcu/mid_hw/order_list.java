package com.fcu.mid_hw;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class order_list extends AppCompatActivity {

    RecyclerView rv;

    static final String db_name="restDB";
    static final String tb_name="orders1";

    String[] restaurantArray = {"","","",""};
    String[] orderTimeArray = {"","","",""};
    //Integer[] statArray = {0,2, 2, 3, 4, 3, 1, 1, 4};
    String[] statArray = {"","","",""};
    String[] delivererArray = {"","","",""};
    String[] priceArray = {"","","",""};
    public Integer j;
    SQLiteDatabase db;
    //123

    CustomAdapter ad;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list);

        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
        Cursor c=db.rawQuery("SELECT * FROM "+tb_name,null);

        j=0;
        if(c.moveToFirst()){

            do{
                restaurantArray[j]=c.getString(0);
                orderTimeArray[j]= c.getString(1);
                delivererArray[j]= c.getString(2);
                priceArray[j]=c.getString(3);
                statArray[j]=c.getString(4);
                j=j+1;
            } while (c.moveToNext());

        }

        rv = (RecyclerView)findViewById(R.id.rv);
        ad = new CustomAdapter(order_list.this, restaurantArray, orderTimeArray, statArray, delivererArray, priceArray);
        rv.setAdapter(ad);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }

    public void btosurch(View view)
    {
        db.close();
        Intent intent = new Intent();
        intent.setClass(order_list.this, user_Search.class);
        startActivity(intent);
    }
}