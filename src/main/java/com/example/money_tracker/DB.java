package com.example.money_tracker;

import static com.example.money_tracker.CalendarFragment.date_search;
import static com.example.money_tracker.DB_Names.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String creation_query= "CREATE TABLE "
                + TABLE_Info + "("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_AMOUNT + " INTEGER, "
                + KEY_NOTE + " TEXT, "
                + KEY_TYPE + " TEXT, "
                + KEY_CATEGORY + " TEXT, "
                + KEY_IMAGE + " TEXT, "
                + KEY_HISTORY + " TEXT)";
        sqLiteDatabase.execSQL(creation_query);

        String creation_query2= "CREATE TABLE "
                + TABLE_CAT + "("
                + KEY_Id + " INTEGER PRIMARY KEY, "
                + KEY_Cat + " TEXT)";
        sqLiteDatabase.execSQL(creation_query2);

        String creation_query3= "CREATE TABLE "
                + TABLE_IMAGE + "("
                + KEY_id + " INTEGER PRIMARY KEY, "
                + KEY_NAME + " TEXT, "
                + KEY_PHOTO + " TEXT)";
        sqLiteDatabase.execSQL(creation_query3);

        String creation_query4= "CREATE TABLE "
                + TABLE_USER + "("
                + KEY_iD + " INTEGER PRIMARY KEY, "
                + KEY_EMAIL + " TEXT, "
                + KEY_PASSWORD + " TEXT)";
        sqLiteDatabase.execSQL(creation_query4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_Info);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_CAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_IMAGE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        onCreate(sqLiteDatabase);
    }

    void addTransaction(Transaction t){
        SQLiteDatabase db = this.getWritableDatabase();
        System.out.println(t.getHistory());
        ContentValues v = new ContentValues();
        v.put(KEY_AMOUNT, t.getAmount());
        v.put(KEY_NOTE, t.getNote());
        v.put(KEY_TYPE, t.getType());
        v.put(KEY_CATEGORY, t.getCategory());
        v.put(KEY_IMAGE, t.getImage());
        v.put(KEY_HISTORY, t.getHistory());
        db.insert(TABLE_Info, null, v);
        db.close();
    }

    public List<Transaction> getAll() {
        List<Transaction> transactionList = new ArrayList<Transaction>();
        String selectQuery = "SELECT  * FROM "+TABLE_Info;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Transaction transaction = new Transaction();
                transaction.setID(Integer.parseInt(cursor.getString(0)));
                transaction.setAmount(cursor.getString(1));
                transaction.setNote(cursor.getString(2));
                transaction.setType(cursor.getString(3));
                transaction.setCategory(cursor.getString(4));
                transaction.setImage(cursor.getInt(5));
                transactionList.add(transaction);
            } while (cursor.moveToNext());
        }
        return transactionList;
    }

    void addCategory(String cat){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(KEY_Cat, cat);
        db.insert(TABLE_CAT, null, v);
        db.close();
    }

    public List<String> getAllCat() {
        List<String> list = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM "+TABLE_CAT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public void Delete(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Info, KEY_ID + "=?" , new String[]{String.valueOf(id)});
        db.close();
    }

    public List<Transaction> getIncome() {
        List<Transaction> transactionList = new ArrayList<Transaction>();
        String selectQuery = "SELECT  * FROM "+TABLE_Info+ " WHERE Type = 'Income' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Transaction transaction = new Transaction();
                transaction.setID(Integer.parseInt(cursor.getString(0)));
                transaction.setAmount(cursor.getString(1));
                transaction.setNote(cursor.getString(2));
                transaction.setType(cursor.getString(3));
                transaction.setCategory(cursor.getString(4));
                transaction.setImage(cursor.getInt(5));
                transactionList.add(transaction);
            } while (cursor.moveToNext());
        }
        return transactionList;
    }

    public List<Transaction> getExpenses() {
        List<Transaction> transactionList = new ArrayList<Transaction>();
        String selectQuery = "SELECT  * FROM "+TABLE_Info+ " WHERE Type = 'Expenses' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Transaction transaction = new Transaction();
                transaction.setID(Integer.parseInt(cursor.getString(0)));
                transaction.setAmount(cursor.getString(1));
                transaction.setNote(cursor.getString(2));
                transaction.setType(cursor.getString(3));
                transaction.setCategory(cursor.getString(4));
                transaction.setImage(cursor.getInt(5));
                transactionList.add(transaction);
            } while (cursor.moveToNext());
        }
        return transactionList;
    }

    public List<Transaction> getHistory() {
        List<Transaction> transactionList = new ArrayList<Transaction>();
        String selectQuery = "SELECT  * FROM "+TABLE_Info+ " WHERE Date ='"+date_search+"'  ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Transaction transaction = new Transaction();
                transaction.setID(Integer.parseInt(cursor.getString(0)));
                transaction.setAmount(cursor.getString(1));
                transaction.setNote(cursor.getString(2));
                transaction.setType(cursor.getString(3));
                transaction.setCategory(cursor.getString(4));
                transaction.setImage(cursor.getInt(5));
                transactionList.add(transaction);
            } while (cursor.moveToNext());
        }
        return transactionList;
    }

    public List<String> getType() {
        List<String> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+TABLE_Info;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(3));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public List<String> getCategory() {
        List<String> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+TABLE_Info;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        return list;
    }

    void addImage(SavedImage s){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(KEY_NAME, s.getTitle());
        v.put(KEY_PHOTO, s.getPhoto());
        db.insert(TABLE_IMAGE, null, v);
        db.close();
    }

    public List<SavedImage> getAllImage() {
        List<SavedImage> savedImageList = new ArrayList<SavedImage>();
        String selectQuery = "SELECT  * FROM "+TABLE_IMAGE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                SavedImage savedImage = new SavedImage();
                savedImage.setId(Integer.parseInt(cursor.getString(0)));
                savedImage.setTitle(cursor.getString(1));
                savedImage.setPhoto(cursor.getString(2));
                savedImageList.add(savedImage);
            } while (cursor.moveToNext());
        }
        return savedImageList;
    }

    void addInfo(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(KEY_EMAIL, email);
        v.put(KEY_PASSWORD, password);
        db.insert(TABLE_USER, null, v);
        db.close();
    }

    public String getPassword() {
        String password = " ";
        String selectQuery = "SELECT  * FROM "+TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do { 
                password = cursor.getString(2);
                System.out.println(password);
            } while (cursor.moveToNext());
        }
        return password;
    }

    public String getEmail() {
        String email = " ";
        String selectQuery = "SELECT  * FROM "+TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                email = cursor.getString(1);
            } while (cursor.moveToNext());
        }
        return email;
    }

    public void ForgetPassword(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(KEY_PASSWORD,password);
        db.update(TABLE_USER,v,KEY_EMAIL+ "=?",new String[]{email});
    }
}
