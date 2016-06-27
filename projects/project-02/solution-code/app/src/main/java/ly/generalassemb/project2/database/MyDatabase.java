package ly.generalassemb.project2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import ly.generalassemb.project2.R;
import ly.generalassemb.project2.database.contracts.OrdersDatabaseContract;
import ly.generalassemb.project2.database.contracts.ProductsDatabaseContract;
import ly.generalassemb.project2.database.contracts.PurchasedDatabaseContract;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/20/16.
 */

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "data.db";


    // ================================================================================ CONSTRUCTORS


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        loadAllData(context);
    }

    // ============================================================================== HELPER METHODS

    public Cursor getAllProducts(){
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.query(ProductsDatabaseContract.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        return cursor;
    }

    public Cursor getProductById(long productId) {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.query(ProductsDatabaseContract.TABLE_NAME,
                null,
                ProductsDatabaseContract._ID + " = ?",
                new String[]{productId + ""},
                null, null, null);
        cursor.moveToFirst();
        return cursor;
    }


    // ============================================================================== DATABASE SETUP

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ProductsDatabaseContract.getCreateTableStatement());
        db.execSQL(PurchasedDatabaseContract.getCreateTableStatement());
        db.execSQL(OrdersDatabaseContract.getCreateTableStatement());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ProductsDatabaseContract.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PurchasedDatabaseContract.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + OrdersDatabaseContract.TABLE_NAME);
        onCreate(db);
    }

    public void loadAllData(Context context) {
        SQLiteDatabase db = getWritableDatabase();

        boolean hasNoProducts = true;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM" + ProductsDatabaseContract.TABLE_NAME, null);
        hasNoProducts = cursor != null && cursor.moveToFirst();

        if (hasNoProducts) {

            db.beginTransaction();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.products_sql)));

            try {
                while (inputStream.ready()) {
                    try {
                        db.execSQL(inputStream.readLine());
                    } catch (Throwable thr) {
                    }
                }

                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            db.setTransactionSuccessful();
            db.endTransaction();
        }
    }
}
