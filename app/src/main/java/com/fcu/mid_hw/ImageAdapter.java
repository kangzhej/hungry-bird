package com.fcu.mid_hw;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class ImageAdapter extends ArrayAdapter<Integer> {

    private Context context;
    private Integer[] imageList;

    public ImageAdapter(@NonNull Context context, Integer[] imgList ) {
        super(context, 0, imgList);
        this.context = context;
        this.imageList = imgList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView iv = new ImageView(this.context);
        int resId = imageList[position];
        iv.setImageResource(resId);
        iv.setAdjustViewBounds(true);
        return iv;

    }
}
