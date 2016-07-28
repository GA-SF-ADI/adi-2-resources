package com.test.stockportfolio;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by nolbertoarroyo on 7/27/16.
 */
public class MyContentProvider extends ContentProvider {
    StocksDatabaseHelper helper;
    private static final String AUTHORITY = "com.example.database.provider.MyContentProvider";
    private static final String STOCKS_TABLE = "stocks";
    public static final Uri CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + STOCKS_TABLE);

    public static final int STOCKS = 1;
    public static final int STOCKS_ID = 2;
    public static final int STOCKS_SYMBOLS = 3;

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(AUTHORITY, STOCKS_TABLE, STOCKS);
        sURIMatcher.addURI(AUTHORITY, STOCKS_TABLE + "/#", STOCKS_ID);
        sURIMatcher.addURI(AUTHORITY, STOCKS_TABLE, STOCKS_SYMBOLS);

    }

    @Override
    public boolean onCreate() {
        helper = new StocksDatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String selection, String[] strings1, String s1) {
        int uriType = sURIMatcher.match(uri);
        Cursor cursor = null;

        switch (uriType) {
            case STOCKS_ID:

                break;
            case STOCKS:
                cursor = helper.getStocks(selection);
                break;
            case STOCKS_SYMBOLS:
                cursor = helper.getStockSymbols(selection);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI");
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {

        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        int uriType = sURIMatcher.match(uri);

        long id = 0;
        switch (uriType) {
            case STOCKS:
                id = helper.addStock(contentValues);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(STOCKS_TABLE + "/" + id);
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        int uriType = sURIMatcher.match(uri);
        SQLiteDatabase sqlDB = helper.getWritableDatabase();
        int rowsDeleted = 0;

        switch (uriType) {
            case STOCKS:
                break;
            case STOCKS_ID:
                String id = uri.getLastPathSegment();
                rowsDeleted = helper.deleteStock(id);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
