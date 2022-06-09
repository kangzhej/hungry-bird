package com.fcu.mid_hw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context mContext;
    private String[] mRest;
    private String[] mOrderTime;
    private String[] mstat;
    private String[] mdeliverer;
    private String[] mprice;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView rest;
        TextView orderTime;
        TextView stat;
        TextView deliverer;
        TextView price;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.rest = (TextView) itemView.findViewById(R.id.restaurant);
            this.orderTime = (TextView) itemView.findViewById(R.id.order_time);
            this.stat = (TextView) itemView.findViewById(R.id.status);
            this.deliverer = (TextView) itemView.findViewById(R.id.deliverer);
            this.price = (TextView) itemView.findViewById(R.id.price);
        }
    }
    public CustomAdapter(Context mContext, String[] restaurant, String[] orderTime, String[] statArray, String[] delivererArray, String[] priceArray) {
        this.mContext = mContext;
        this.mRest = restaurant;
        this.mOrderTime = orderTime;
        this.mstat = statArray;
        this.mdeliverer = delivererArray;
        this.mprice = priceArray;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int i) {
        holder.rest.setText(mRest[i]);
        holder.orderTime.setText(mOrderTime[i] + "ordered");

        holder.stat.setText(mstat[i]);
        /*
        switch(mstat[i])
        {
            case 0:
                holder.stat.setText("status 1");
                break;

            case 1:
                holder.stat.setText("status 2");
                break;

            case 2:
                holder.stat.setText("status 3");
                break;

            case 3:
                holder.stat.setText("status 4");
                break;

            case 4:
                holder.stat.setText("status 5");
                break;
        }
        */
        holder.deliverer.setText("deliverer: " + mdeliverer[i]);
        holder.price.setText("price: " + mprice[i]);
    }
    @Override
    public int getItemCount() {
        return mRest.length;
    }
}