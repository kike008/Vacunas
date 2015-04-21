package com.example.kike.vacunas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KIKE on 19/04/2015.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table vacunacion (id_A integer primary key unique, comunidad text, mvz text,  telefono integer, perros integer, gatos integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists vacunacion");
        db.execSQL("create table vacunacion (id_A integer primary key unique, comunidad text, mvz text,  telefono integer, perros integer, gatos integer) ");


    }
}
