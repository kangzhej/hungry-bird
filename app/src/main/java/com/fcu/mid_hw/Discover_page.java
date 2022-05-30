package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class Discover_page extends AppCompatActivity implements View.OnClickListener{

    Button btn7;


    private Integer[] taipeiPhotos = {R.drawable.barbecue, R.drawable.bread,
            R.drawable.breakfast, R.drawable.food, R.drawable.eclair,
            R.drawable.meat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover);

        Integer[] selectedPhotos = taipeiPhotos;

        GridView gvPhotos = this.findViewById(R.id.gv_photos);
        gvPhotos.setNumColumns(2);
        ImageAdapter ia = new ImageAdapter(this, selectedPhotos);
        gvPhotos.setAdapter(ia);


        btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(this);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button7:
                Intent intent = new Intent();
                intent.setClass(Discover_page.this, Profile_page.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void onRes(View view){
        Intent intent = new Intent();
        intent.setClass(Discover_page.this, Profile_page.class);
        startActivity(intent);
    }
}
