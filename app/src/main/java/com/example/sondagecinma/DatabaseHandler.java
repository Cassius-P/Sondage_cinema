package com.example.sondagecinma;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import  android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    //Database VErsion
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "dbb.db";

    //Table Name
    private static final String TABLE_NAME = "buttons";

    //Table Fields
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NB = "numbers";

    SQLiteDatabase database;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+ " ( "+COLUMN_ID+"INTEGER PRIMARY KEY, "+COLUMN_NB+" INTEGER)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
