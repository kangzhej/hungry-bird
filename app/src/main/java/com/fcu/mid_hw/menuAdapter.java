package com.fcu.mid_hw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class menuAdapter extends RecyclerView.Adapter<menuAdapter.MyViewHolder> {
    private Context mContext;
    private String[] mdish;
    private String[] mprice;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dish;
        TextView price;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.dish = (TextView) itemView.findViewById(R.id.dishName);
            this.price = (TextView) itemView.findViewById(R.id.dish_price);
        }
    }
    public menuAdapter(Context mContext, String[] dishes, String[] priceArray) {
        this.mContext = mContext;
        this.mdish = dishes;
        this.mprice = priceArray;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_card, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int i) {
        holder.dish.setText(mdish[i]);
        holder.price.setText("price: " + mprice[i]);
    }
    @Override
    public int getItemCount() {
        return mdish.length;
    }
}