package com.fcu.mid_hw;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class menu extends AppCompatActivity {

    RecyclerView rv;

    String[] dishArray = {"set A","set B","set C","set D","set E","set F","set G","set H","set I","set J"};
    String[] priceArray = {"123","234","147","258","369","21","32","54","43","65"};

    //123

    menuAdapter ad;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        ImageView restIMG = this.findViewById(R.id.restaurant_img);
        restIMG.setImageResource(R.drawable.logo);

        TextView restName = this.findViewById(R.id.restName);
        restName.setText("Restaurant A");

        TextView restAddr = this.findViewById(R.id.restAddress);
        restAddr.setText("407台中市西屯區文華路100號");


        rv = (RecyclerView)findViewById(R.id.menu_rv);
        ad = new menuAdapter(menu.this, dishArray, priceArray);
        rv.setAdapter(ad);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }
}