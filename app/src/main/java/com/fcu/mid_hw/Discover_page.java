package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class Discover_page extends AppCompatActivity{

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
    }
}
