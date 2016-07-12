package com.example.franciscofranco.customadapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by FranciscoFranco on 7/12/16.
 */
public class SqlDbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_TABLE = "PHONE_CONTACTS";

    public static final String COLUMN1 = "slno";
    public static final String COLUMN2 = "name";
    public static final String COLUMN3 = "phone";

    private static final String SCRIPT_CREATE_DATABASE = "create table " +
            DATABASE_TABLE + " (" + COLUMN1 + " integer primary key autoincrement, " +
            COLUMN2 + " text not null, " + COLUMN3 + " text not null);";

    public SqlDbHelper(Context context, String name,
                       int version) {
        super(context, name, null, version);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + DATABASE_TABLE);
        onCreate(db);
    }
}
