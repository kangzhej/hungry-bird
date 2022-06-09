package com.fcu.mid_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class database extends AppCompatActivity {

    static final String db_name="restDB";
    //static final String tb_name="info";
    static final String tb_name="order1";
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);



        //open database
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);


    /*    String createTable = "Create Table If Not Exists " +
                tb_name +
                "(id INT(16), " +
                "name VARCHAR(32), " +
                "email VARCHAR(64))" ;
        db.execSQL(createTable);
    */
        String createTable = "Create Table If Not Exists " +
                tb_name +
                "(id INT(16), " +
                "name VARCHAR(32), " +
                "driver VARCHAR(32)," +
                "time VARCHAR(32)," +
                "price VARCHAR(32))";
        db.execSQL(createTable);




        Cursor c=db.rawQuery("SELECT * FROM "+tb_name,null);


        if (c.getCount()==0){
            //call addData
            addData(1,"kk","tom" ,"10:11","100");
            addData(2,"name","Jhon" ,"10:20","120");
            addData(3,"eric","Coco" ,"10:30","220");
            addData(4,"may","Willy" ,"10:33","80");


            c=db.rawQuery("SELECT * FROM "+tb_name,null);

        }


        TextView txv = (TextView) findViewById(R.id.txv);
        txv.setText("資料庫path: " + db.getPath() + "\n");


        //db.close();



        if(c.moveToFirst()){
            String str="總共有 "+c.getCount()+"筆資料\n" ;
            str+="-----\n";

            do{
                str+="id: " + c.getString(0)+"\n";
                str+="name: " + c.getString(1)+"\n";
                str+="driver: " + c.getString(2)+"\n";
                str+="time1: " + c.getString(3)+"\n";
                str+="price: " + c.getString(4)+"\n";
                str+="-----\n";
            } while (c.moveToNext());

            TextView txv2=(TextView) findViewById(R.id.txv2);
            txv2.setText(str);

        }

    }


/*
    private void addData(Integer id,String name,String email) {
        ContentValues cv=new ContentValues(3);

        cv.put("id",id);
        cv.put("name",name);
        cv.put("email",email);

        db.insert(tb_name,null,cv);

    }
*/
    private void addData(Integer id,String name,String driver,String time,String price) {
        ContentValues cv=new ContentValues(5);

        cv.put("id",id);
        cv.put("name",name);
        cv.put("driver",driver);
        cv.put("time",time);
        cv.put("price",price);

        db.insert(tb_name,null,cv);

    }


}