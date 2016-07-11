package com.example.hollis.sharedpreferenceexample;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Parcelable;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by hollis on 6/30/16.
 */
public class WeatherSQliteOpenHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Weather_DB";
    public static final String TABLE_NAME = "Weather";

    public static final String COL_ID = "_id";
    public static final String COL_TEMP_CEL = "Celsius";
    public static final String COL_TEMP_FAHR = "Fahrenheit";
    public static final String COL_TEMP_KELVIN = "Kelvin";

    public static final String COL_DAY = "Date";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "( " +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_TEMP_CEL + " INTEGER, " +
            COL_TEMP_FAHR + " INTEGER, " +
            COL_TEMP_KELVIN + " INTEGER, " +
            COL_DAY + " TEXT)";

    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static WeatherSQliteOpenHelper instance;


    public static WeatherSQliteOpenHelper getInstance(Context context){
        if(instance==null) {
            instance = new WeatherSQliteOpenHelper(context.getApplicationContext());
        }
        return instance;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE);
        this.onCreate(db);
    }
    public WeatherSQliteOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insert(Weather weather){
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        values.put(COL_DAY, weather.getDay());
        values.put(COL_TEMP_CEL, weather.getCelsius());
        values.put(COL_TEMP_FAHR, weather.getFahrenheit());
        values.put(COL_TEMP_KELVIN, weather.getKelvin());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //This takes in a column name and gets
    public Cursor getTemp(String column){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {COL_ID, COL_DAY, column};
        Cursor cursor = db.query(TABLE_NAME,projection, null, null, null, null, null);
        return cursor;
    }


}
