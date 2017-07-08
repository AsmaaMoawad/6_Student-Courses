package com.example.asmaa.dss_task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Asmaa on 29-Apr-17.
 */

public class Mydatabase_Sqlite extends SQLiteOpenHelper {

    public final static String database_name = "Users_Data";

    public final static String table_name = "Student";

    public final static String key_email = "email";
    public final static String key_pass = "pass";
    public final static String key_fname = "fname";
    public final static String key_lname = "lname";


    public Mydatabase_Sqlite(Context context) {

        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = "CREATE TABLE " + table_name + "(" + key_email + " TEXT UNIQUE, " + key_fname + " TEXT UNIQUE, " + key_lname + " TEXT UNIQUE, " + key_pass + " TEXT)";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + table_name);

    }


    public boolean insert(Users_Data data) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(key_pass, data.password);
        values.put(key_email, data.email);
        values.put(key_lname, data.lname);
        values.put(key_fname, data.fname);


        long rowInserted = db.insert(table_name, null, values);

        if (rowInserted != -1) {
            db.close();
            return true;
        } else {
            db.close();
            return false;
        }


    }


    public boolean login(String email, String pass) {
        String query = "SELECT *"
                + " FROM " + table_name
                + " WHERE " + key_email + " = '" + email
                + "' AND " + key_pass + " = '" + pass + "' ; ";
        Log.d("My Query", query);


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }


    }

    public Boolean CheckPass(String email, String fname,String lname) {
//        String query = "SELECT *"
//                + " FROM " + table_name
//                + " WHERE " + key_email + " = '" + email
//                + "' AND " + key_lname + " = '" + lname
//                + "' AND " + key_fname + " = '" + fname + "' ; ";
        String query= "SELECT * FROM "+table_name+" WHERE email = '"+email+ "' AND lname = '"+lname+"' AND fname = '"+fname+"';";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }


    }

    public void updatepass(String password,String email){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(key_pass,password);
        //db.update(table_name, cv, "email="+email, null);
        db.update(table_name, cv, "email = '" + email +"'", null);

    }




}












//    public Boolean CheckPass(String email, String fname,String lname) {
////        String query = "SELECT *"
////                + " FROM " + table_name
////                + " WHERE " + key_email + " = '" + email
////                + "' AND " + key_lname + " = '" + lname
////                + "' AND " + key_fname + " = '" + fname + "' ; ";
//       String query= "SELECT * FROM "+table_name+" WHERE email = '"+key_email+ "' AND lname = '"+key_lname+"' AND fname = '"+key_fname+"'";
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        if (cursor.moveToFirst()) {
//            return true;
//        } else {
//            return false;
//        }
//
//
//    }

