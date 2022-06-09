package com.fcu.mid_hw;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class order_list extends AppCompatActivity {

    RecyclerView rv;

    String[] restaurantArray = {"restaurant Never","restaurant Gonna","restaurant Give","restaurant You","restaurant Up","restaurant Never","restaurant Gonna","restaurant Let","restaurant You","restaurant Down"};
    String[] orderTimeArray = {"01:23","02:34","","03:45","04:56","05:12","06:23","07:34","08:45","09:56"};
    Integer[] statArray = {0, 2, 2, 3, 4, 3, 1, 1, 4};
    String[] delivererArray = {"alex","betty","carl","dave","eric","frank","george","harry","iris","john"};
    String[] priceArray = {"123","234","147","258","369","21","32","54","43","65"};

    //123

    CustomAdapter ad;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list);
        rv = (RecyclerView)findViewById(R.id.rv);
        ad = new CustomAdapter(order_list.this, restaurantArray, orderTimeArray, statArray, delivererArray, priceArray);
        rv.setAdapter(ad);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }
}