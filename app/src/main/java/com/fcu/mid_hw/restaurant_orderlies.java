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
    static final String tb_name="info";
    public Integer j;
    SQLiteDatabase db;


    String[] restaurantArray = {"restaurant Never","restaurant Gonna","restaurant Give","restaurant You"};
    String[] orderTimeArray = {"01:23","02:34","","03:45"};
    Integer[] statArray = {0, 2, 2, 3};
    String[] delivererArray = {"alex","betty","carl","dave"};
    String[] priceArray = {"123","234","147","258"};

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