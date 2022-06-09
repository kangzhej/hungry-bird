package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class restaurant_menu extends AppCompatActivity {

    static final String db_name="restDB";
    static final String tb_name="menu";
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurand_menu);

        EditText Setoid = findViewById(R.id.rest_id);
        EditText etname = findViewById(R.id.food_name);
        EditText etprice = findViewById(R.id.food_price);

        String id = Setoid.getText().toString();
        String name = etname.getText().toString();
        String price = etprice.getText().toString();




        //open database
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
        String createTable = "Create Table If Not Exists " +
                tb_name +
                "(id VARCHAR(16), " +
                "name VARCHAR(32), " +
                "price VARCHAR(16))";
        db.execSQL(createTable);

        //---------------------------------------
        Cursor c=db.rawQuery("SELECT * FROM "+tb_name,null);

        addData(id,name,price);
        //if (c.getCount()==0){
        //call addData
        //addData(2,"珍奶", 120);
        //c=db.rawQuery("SELECT * FROM "+tb_name,null);
        //}
        db.close();

        if(c.moveToFirst()){
            String str="總共有 "+c.getCount()+"筆資料\n" ;
            str+="-----\n";

            do{
                str += "id: " + c.getString(0)+"\n";
                str += "name: " + c.getString(1)+"\n";
                str += "price: " + c.getString(2)+"\n";
                str += "-----\n";
            } while (c.moveToNext());

            TextView txv3=(TextView) findViewById(R.id.txv3);
            txv3.setText(str);

        }




    }

    private void  addData(String id,String name,String price) {
        ContentValues cv=new ContentValues(3);

        cv.put("id",id);
        cv.put("name",name);
        cv.put("price",price);

        db.insert(tb_name,null,cv);

    }


}