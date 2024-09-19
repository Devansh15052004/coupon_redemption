package com.example.sem5_project;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "item_storage_database";
    private static final String TABLE_NAME = "items";
    private static final String TABLE_USER_NAME = "name";
    private static final String TABLE_CATEGORY = "category";
    private static final String TABLE_DESCRIPTION = "description";
    private static final String TABLE_DISCOUNT = "discount";
    private static final String TABLE_COUPON_TYPE = "coupontype";

    public ItemDatabase(@Nullable Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String createTable = "CREATE TABLE "+TABLE_NAME+" ( " +
                TABLE_USER_NAME+" TEXT , "+
                TABLE_CATEGORY+" TEXT, "+
                TABLE_DESCRIPTION+" TEXT, "+
                TABLE_DISCOUNT+" TEXT, "+
                TABLE_COUPON_TYPE+" TEXT )";

        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        if (i < i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(sqLiteDatabase);
        }
    }

    public void addItemToDatabase(ItemModule data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(TABLE_USER_NAME, data.name);
        content.put(TABLE_CATEGORY, data.category);
        content.put(TABLE_DESCRIPTION, data.description);
        content.put(TABLE_DISCOUNT, data.discount);
        content.put(TABLE_COUPON_TYPE, data.coupontype);

        // Insert the row into the database
        db.insert(TABLE_NAME, null, content);
        db.close();
    }


    @SuppressLint("Range")
    public ArrayList<ItemModule> geteccommerseFromDatabase() {
        ArrayList<ItemModule> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + TABLE_CATEGORY + " = 'Ecommerce'", null);

        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(TABLE_USER_NAME));
                String category = cursor.getString(cursor.getColumnIndex(TABLE_CATEGORY));
                String discount = cursor.getString(cursor.getColumnIndex(TABLE_DISCOUNT));
                String description = cursor.getString(cursor.getColumnIndex(TABLE_DESCRIPTION));
                String coupontype = cursor.getString(cursor.getColumnIndex(TABLE_COUPON_TYPE));

                list.add(new ItemModule(category, name, discount, description, coupontype));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return list;
    }
    @SuppressLint("Range")
    public ArrayList<ItemModule> gettravelFromDatabase() {
        ArrayList<ItemModule> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + TABLE_CATEGORY + " = 'Travel'", null);

        Log.d("GarlicFragment", "Rows fetched: " + cursor.getCount());

        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(TABLE_USER_NAME));
                String category = cursor.getString(cursor.getColumnIndex(TABLE_CATEGORY));
                String discount = cursor.getString(cursor.getColumnIndex(TABLE_DISCOUNT));
                String description = cursor.getString(cursor.getColumnIndex(TABLE_DESCRIPTION));
                String coupontype = cursor.getString(cursor.getColumnIndex(TABLE_COUPON_TYPE));

                list.add(new ItemModule(category, name, discount, description, coupontype));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return list;
    }

}
