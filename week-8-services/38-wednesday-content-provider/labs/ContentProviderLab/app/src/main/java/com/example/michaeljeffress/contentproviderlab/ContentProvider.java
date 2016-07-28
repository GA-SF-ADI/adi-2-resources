package com.example.michaeljeffress.contentproviderlab;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.Nullable;

/**
 * Created by michaeljeffress on 7/27/16.
 */
public class ContentProvider extends android.content.ContentProvider {

    private DBHelper myDB;
    private static final String AUTHORITY = "dev.markitondemand.com/Api/v2";
    private static final String PRODUCTS_TABLE = "company";
    public static final Uri CONTENT_URI = Uri.parse("http://"
            + AUTHORITY + "/" + PRODUCTS_TABLE);

    public static final int PRODUCTS = 1;
    public static final int PRODUCTS_ID = 2;

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(AUTHORITY, PRODUCTS_TABLE, PRODUCTS);
        sURIMatcher.addURI(AUTHORITY, PRODUCTS_TABLE + "/#", PRODUCTS_ID);
    }

    @Override
    public boolean onCreate() {
        myDB = new DBHelper(getContext(), null, null, 1);
        return false;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = sURIMatcher.match(uri);

        long id = 0;
        switch (uriType) {
            case PRODUCTS:
                id = myDB.addCompany(values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(PRODUCTS_TABLE + "/" + id);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int uriType = sURIMatcher.match(uri);
        Cursor cursor = null;

        switch (uriType) {
            case PRODUCTS_ID:
                cursor = myDB.findCompanyById(uri.getLastPathSegment());
                break;
            case PRODUCTS:
                cursor = myDB.findCompanyByName(selection);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI");
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        int uriType = sURIMatcher.match(uri);
        int rowsUpdated = 0;

        switch (uriType) {
            case PRODUCTS:
                rowsUpdated = myDB.updateCompany(values,selection,null);
                break;
            case PRODUCTS_ID:
                String id = uri.getLastPathSegment();
                rowsUpdated = myDB.updateCompany(values,null,id);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsUpdated;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        int uriType = sURIMatcher.match(uri);
        SQLiteDatabase sqlDB = myDB.getWritableDatabase();
        int rowsDeleted = 0;

        switch (uriType) {
            case PRODUCTS:
                rowsDeleted = myDB.deleteCompanyByName(selection);
                break;
            case PRODUCTS_ID:
                String id = uri.getLastPathSegment();
                rowsDeleted = myDB.deleteCompanyById(id);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }
}
