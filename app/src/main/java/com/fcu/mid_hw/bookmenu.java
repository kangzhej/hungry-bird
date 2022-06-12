package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class bookmenu extends AppCompatActivity {

    public Integer tprice,nitem;
    public Integer ntoast,nbbq;
    public String ttxv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmenu);

    }

    public void toast_add(View view)
    {
        TextView txv=(TextView)findViewById(R.id.totle_txv) ;
        ntoast=ntoast+1;
        nitem=nbbq+ntoast;
        tprice=nbbq*100+ntoast*60;

        ttxv="項數"+nitem+"價格"+tprice;
        txv.setText(ttxv);
    }

    public void toast_sub(View view)
    {
        TextView txv=(TextView)findViewById(R.id.totle_txv) ;
        if(ntoast>0)
        {
            ntoast=ntoast-1;
            nitem=nbbq+ntoast;
            tprice=nbbq*100+ntoast*60;
            ttxv="項數"+nitem+"價格"+tprice;
            txv.setText(ttxv);
        }
    }

    public void bbq_add(View view)
    {
        TextView txv=(TextView)findViewById(R.id.totle_txv) ;
        nbbq=nbbq+1;
        nitem=nbbq+ntoast;
        tprice=nbbq*100+ntoast*60;
        ttxv="項數"+nitem+"價格"+tprice;
        txv.setText(ttxv);

    }

    public void bbq_sub(View view)
    {
        TextView txv=(TextView)findViewById(R.id.totle_txv) ;
        if(nbbq>0)
        {
            nbbq=nbbq-1;
            nitem=nbbq+ntoast;
            tprice=nbbq*100+ntoast*60;
            ttxv="項數"+nitem+"價格"+tprice;
            txv.setText(ttxv);

        }

    }

}