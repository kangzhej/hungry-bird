package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class restaurant_orderlies extends AppCompatActivity {

    RecyclerView rv;

    static final String db_name="restDB";
    static final String tb_name="orders";
    public Integer j;
    SQLiteDatabase db;


    String[] restaurantArray = {"","","",""};
    String[] orderTimeArray = {"","","",""};
    String[] statArray = {"","","",""};
    String[] delivererArray = {"","","",""};
    String[] priceArray = {"","","",""};

    CustomAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurand_orderlist);



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

        rv = (RecyclerView)findViewById(R.id.rorderlist_rv);
        ad = new CustomAdapter(restaurant_orderlies.this, restaurantArray, orderTimeArray, statArray, delivererArray, priceArray);
        rv.setAdapter(ad);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);



    }



    public void rob(View view){
        db.close();
        Intent intent = new Intent();
        intent.setClass(restaurant_orderlies.this, profile_restaurant.class);
        startActivity(intent);
    }


}