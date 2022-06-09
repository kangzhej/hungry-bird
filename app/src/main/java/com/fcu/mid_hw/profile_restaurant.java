package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class profile_restaurant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_restaurant);
    }

    public void up_menu(View view){
        Intent intent = new Intent();
        intent.setClass(profile_restaurant.this, restaurant_menu.class);
        startActivity(intent);
    }

    public void r_gotoorderlist(View view){
        Intent intent = new Intent();
        intent.setClass(profile_restaurant.this, restaurant_orderlies.class);
        startActivity(intent);
    }

}