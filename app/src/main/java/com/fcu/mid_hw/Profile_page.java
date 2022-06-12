package com.fcu.mid_hw;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Profile_page extends AppCompatActivity {

    private Integer[] personalPhotos = {R.drawable.barbecue, R.drawable.bread,
            R.drawable.breakfast, R.drawable.food, R.drawable.eclair,
            R.drawable.meat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        /*
        Intent intent = this.getIntent();
        int personID - intent.getIntExtra(ID, 0)
        */
        ImageView profilehoto = this.findViewById(R.id.profilePic);
        profilehoto.setImageResource(R.drawable.pizza_2);

        ((TextView) findViewById(R.id.user_name)).setText("BBQ RESTAURANT");
        ((TextView) findViewById(R.id.position)).setText("TAICHUNG");

        Integer[] selectedPhotos = personalPhotos;

        GridView gvPhotos = this.findViewById(R.id.gv_photos);
        gvPhotos.setNumColumns(2);
        ImageAdapter ia = new ImageAdapter(this, selectedPhotos);
        gvPhotos.setAdapter(ia);
    }

    public void gotomenu(View view)
    {
        Intent intent = new Intent();
        intent.setClass(Profile_page.this, bookmenu.class);
        startActivity(intent);
    }
}

