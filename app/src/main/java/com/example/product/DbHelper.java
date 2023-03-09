package com.example.product;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import androidx.annotation.Nullable;


public class DbHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;

    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    private static final String Table_Product = "_product";

    private static final String productName = "productName";
    private static final String productQuantity = "productQuantity";
    private static final String productId = "productId";
    private static final String productBuyingPrice = "productBuyingPrice";
    private static final String productSellingPrice = "productSellingPrice";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query_Table = "CREATE TABLE IF NOT EXISTS " + Table_Product + "(" +
                productId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                productName + " TEXT, " +
                productQuantity + " INTEGER, " +
                productBuyingPrice + " REAL, " +
                productSellingPrice + " REAL)";
        db.execSQL(Query_Table);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Product);
        onCreate(db);
    }


    public boolean insertProduct(String productName, Integer productQuantity, String productId, Float productBuyingPrice,
                                 Float productSellingPrice) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbHelper.productName, productName);
        values.put(DbHelper.productQuantity, productQuantity);
        values.put(DbHelper.productId, productId);
        values.put(DbHelper.productBuyingPrice, productBuyingPrice);
        values.put(DbHelper.productSellingPrice, productSellingPrice);


        db.insert(Table_Product, null, values);
        return true;
    }




}

