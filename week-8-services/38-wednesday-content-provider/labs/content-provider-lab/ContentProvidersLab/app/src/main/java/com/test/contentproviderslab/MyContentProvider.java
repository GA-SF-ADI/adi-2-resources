package com.test.contentproviderslab;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by audreyeso on 7/27/16.
 */
public class MyContentProvider extends ContentProvider {
    private DBHandler dbHandler;
    private static final String AUTHORITY = "com.test.contentproviderslab.MyContentProvider";
    private static final String STOCK_TABLE ="stocks";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + STOCK_TABLE);

    public static final int STOCK = 1;

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(AUTHORITY,STOCK_TABLE,STOCK);
    }

    @Override
    public boolean onCreate() {
        dbHandler = new DBHandler(getContext(), null, null, 1);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        int uriType =sURIMatcher.match(uri);

        long id = 0;
        switch (uriType) {
            case STOCK:
                id = dbHandler.addStock(contentValues);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(STOCK_TABLE + "/" + id);

    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
